package pageObjects.mortgage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class MainPage {

    private AppiumDriver mobileDriver;

    /**
     * Method Name : MainPage
     * Method Description: Initializes all elements by the constructor
     * gets mobileDriver and sends it to initElements
     * with a limit of 5 seconds
     * @param mobileDriver
     */
    public MainPage(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(5)), this);
    }

    @AndroidFindBy(xpath = "//*[@id='etAmount']")
    private AndroidElement txt_amount;

    @AndroidFindBy(xpath = "//*[@id='etTerm']")
    private AndroidElement txt_term;

    @AndroidFindBy(xpath = "//*[@id='etRate']")
    private AndroidElement txt_rate;

    @AndroidFindBy(xpath = "//*[@id='btnCalculate']")
    private AndroidElement btn_Calculate;

    @AndroidFindBy(xpath = "//*[@id='tvRepayment']")
    private AndroidElement txt_repayment;

    /**
     * Getter
     * @return
     */
    public AppiumDriver getMobileDriver() {
        return mobileDriver;
    }

    public AndroidElement getTxt_amount() {
        return txt_amount;
    }

    public AndroidElement getTxt_term() {
        return txt_term;
    }

    public AndroidElement getTxt_rate() {
        return txt_rate;
    }

    public AndroidElement getBtn_Calculate() {
        return btn_Calculate;
    }

    public AndroidElement getTxt_repayment() {
        return txt_repayment;
    }
}
