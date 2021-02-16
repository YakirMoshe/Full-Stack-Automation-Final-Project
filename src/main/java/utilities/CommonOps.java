package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import workflows.ElectronFlows;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class CommonOps extends Base {

    /**
     * Method Name : getData
     * Method Description: This method get the data from xml configuration file
     * @param nodeName
     * @return
     */
    public static String getData(String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    /**
     * Method Name : initBrowser
     * Method Description: This method is used to start a browser session and maximizes browser's window
     * (Depended browser type - the method receives desired browser type)
     * @param browserType
     */
    public static void initBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if (browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else
            throw new RuntimeException("Invalid Browser Type");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        driver.get(getData("url"));
        ManagePages.initGrafana();
        action = new Actions(driver);
    }

    /**
     * Method Name : initChromeDriver
     * Method Description: This method is used to initiate Chrome WebDriver and returns it to initBrowser method, to start a session
     * @return
     */
    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    /**
     * Method Name : initFirefoxDriver
     * Method Description: This method is used to initiate Firefox WebDriver and returns it to initBrowser method, to start a session
     * @return
     */
    public static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    /**
     * Method Name : initIEDriver
     * Method Description: This method is used to initiate Internet Explorer WebDriver and returns it to initBrowser method, to start a session
     * @return
     */
    public static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    /**
     * Method Name : initMobile
     * Method Description: This method is used to initiate mobile WebDriver and sets mobile application to work with(info from DataConfig.xml file)
     * Used Appium Studio to work with mobile application
     */
    public static void initMobile() {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
        try {
            mobileDriver = new AndroidDriver(new URL(getData("AppiumServer")), dc);

        } catch (Exception e) {
            System.out.println("Can not connect to appium server, see details: " + e);
        }
        ManagePages.initMortgage();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, Long.parseLong(getData("Timeout")));
        action = new Actions(driver);
    }

    /**
     * Method Name : initAPI
     * Method Description: This method is used to initiate Web API. RestAssured was selected to work with API
     * Login credentials and URL to Grafana were taken from DataConfig.xml file
     * Also the method deletes teams that were created before, under specific Grafana user profile
     */
    public static void initAPI() {
        RestAssured.baseURI = getData("urlAPI");
        httpRequest = RestAssured.given().auth().preemptive().basic(getData("UserName"), getData("Password"));
    }

    /**
     * Method Name : initElectron
     * Method Description: This method is used to initiate Electron Driver to work with Electron application
     */
    public static void initElectron() {
        System.setProperty("webdriver.chrome.driver", getData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc.setCapability("chromeOptions", opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        ManagePages.initTodo();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        action = new Actions(driver);
    }

    /**
     * Method Name : initDesktop
     * Method Description: This method is used to initiate Windows Driver to work with Desktop application
     */
    public static void initDesktop() {
        dc.setCapability("app", getData("CalculatorApp"));

        try {
            driver = new WindowsDriver(new URL(getData("AppiumServerDesktop")), dc);
        } catch (Exception e) {
            System.out.println("Can not Connect to Appium Server, See Details" + e);
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        ManagePages.initCalculator();
    }

    /**
     * Method Name : startSession
     * Method Description: This method receives Platform parameter (web, mobile, api, electron, desktop etc) and then calls another method to initiate its driver
     * Then it calls to another method to initiate PageObjects (elements on page)
     * Also it calls the method which initiates connection to DB with values taken from DataConfig.xml file
     */
    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName) {
        platform = PlatformName;
        if (platform.equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));
        else if (platform.equalsIgnoreCase("mobile"))
            initMobile();
        else if (platform.equalsIgnoreCase("api"))
            initAPI();
        else if (platform.equalsIgnoreCase("electron"))
            initElectron();
        else if (platform.equalsIgnoreCase("desktop"))
            initDesktop();
        else if (platform.equalsIgnoreCase("webdb"))
            initBrowser(getData("BrowserName"));
        else
            throw new RuntimeException("Invalid platform name");

        softAssert = new SoftAssert();
        screen = new Screen();
        ManageDB.openConnection(getData("DBURL"), getData("DBUserName"), getData("DBPassword"));
    }

    /**
     * Method Name : closeSession
     * Method Description: This method is used to close connection with DB and for ending the session after finishing tests run (not including API tests)
     */
    @AfterClass
    public void closeSession() {
        ManageDB.closeConnection();
        if (!platform.equalsIgnoreCase("api")) {
            if (!platform.equalsIgnoreCase("mobile"))
                driver.quit();
            else
                mobileDriver.quit();
        }
    }

    /**
     * Method Name : beforeMethod
     * Method Description: This method is use to start videos before each test (not including API tests)
     */
    @BeforeMethod
    public void beforeMethod(Method method) {
        if (!platform.equalsIgnoreCase("api")) {
            try {
                MonteScreenRecorder.startRecord(method.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method Name : afterMethod
     * Method Description: This method is used to open Grafana WebPage after each test. Using URL from DataConfig.xml file (only in case when working with WebDriver/Electron)
     */
    @AfterMethod
    public void afterMethod() {
        if (platform.equalsIgnoreCase("web"))
            driver.get(getData("url"));
        else if (platform.equalsIgnoreCase("electron"))
            ElectronFlows.emptyList();
    }


}
