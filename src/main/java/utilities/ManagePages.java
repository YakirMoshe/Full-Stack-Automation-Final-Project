package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.grafana.ServerAdminMainPage;
import pageObjects.grafana.ServerAdminMenuPage;

public class ManagePages extends Base {

    /**
     * Method Name : initGrafana
     * Method Description: This method initiates web/desktop elements on pages/apps. Used POM (Page Object Model)
     */
    public static void initGrafana() {
        grafanaLogin = PageFactory.initElements(driver, pageObjects.grafana.LoginPage.class);
        grafanaMain = PageFactory.initElements(driver, pageObjects.grafana.MainPage.class);
        grafanaLeftMenu = PageFactory.initElements(driver, pageObjects.grafana.LeftMenuPage.class);
        grafanaServerAdminMenu = PageFactory.initElements(driver, ServerAdminMenuPage.class);
        grafanaServerAdminMain = PageFactory.initElements(driver, ServerAdminMainPage.class);
        grafanaAddNewUser = PageFactory.initElements(driver, pageObjects.grafana.AddNewUserPage.class);
        grafanaEditUser = PageFactory.initElements(driver, pageObjects.grafana.EditUserPage.class);
    }

    /**
     * Mobile
     */
    public static void initMortgage() {
        mortgageMain = new pageObjects.mortgage.MainPage(mobileDriver);
    }

    /**
     * Electron
     */
    public static void initTodo() {
        todoMain = PageFactory.initElements(driver, pageObjects.todo.MainPage.class);
    }

    /**
     * Desktop
     */
    public static void initCalculator() {
        calcMain = PageFactory.initElements(driver, pageObjects.calculator.MainPage.class);
    }
}
