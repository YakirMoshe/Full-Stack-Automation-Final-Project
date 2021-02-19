package sanity;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.*;
import utilities.CommonOps;
import workflows.WebFlows;


@Listeners(utilities.Listeners.class)
public class GrafanaWeb extends CommonOps {

    @Test(description = "test01 - Verify Header")
    @Description("This Test login and verifies the main header")
    public void test01_verifyHeader() {
        WebFlows.login(getData("UserName"), getData("Password"));
        Verifications.verifyTextInElement(grafanaMain.getHead_Dashboard(), "Home Dashboard");
    }

    @Test(description = "test02 - Default Users")
    @Description("This Test verifies the default users")
    public void test02_verifyDefaultUsers() {
        UIActions.mouseHover(grafanaLeftMenu.getBtn_server(), grafanaServerAdminMenu.getLink_users());
        Verifications.numberOfElements(grafanaServerAdminMain.getRows(), 1);
    }

    @Test(description = "test03 - Verify New User")
    @Description("This Test verifies a new user has been added")
    public void test03_verifyNewUser() {
        UIActions.mouseHover(grafanaLeftMenu.getBtn_server(), grafanaServerAdminMenu.getLink_users());
        WebFlows.createNewUser("Yakir", "yakir@gmail.com", "YakirM", "12345");
        Verifications.numberOfElements(grafanaServerAdminMain.getRows(), 2);
    }

    @Test(description = "test04 - Verify User Deletion")
    @Description("This Test verifies the deletion of a user")
    public void test04_verifyUserDeletion() {
        UIActions.mouseHover(grafanaLeftMenu.getBtn_server(), grafanaServerAdminMenu.getLink_users());
        WebFlows.deleteLastUser();
        Verifications.numberOfElements(grafanaServerAdminMain.getRows(), 1);
    }

    @Test(description = "test05 - Verify Progress Steps")
    @Description("This Test verifies the default progress steps are displayed (using soft assertion)")
    public void test05_verifyProgressSteps() {
        Verifications.visibilityOfElements(grafanaMain.getList_progressSteps());

    }

    @Test(description = "test06 - Verify Avatar Icon")
    @Description("This Test verifies the Avatar Image Using Sikuli tool")
    public void test06_verifyAvatarIcon() {
        Verifications.visualElement("GrafanaAvater");
    }

    @Test(description = "test07 - Search Users", dataProvider = "data-provider-users", dataProviderClass = utilities.ManageDDT.class)
    @Description("This Test Searched Users in a table using DDT")
    public void test07_searchUsers(String user, String shouldExist) {
        UIActions.mouseHover(grafanaLeftMenu.getBtn_server(), grafanaServerAdminMenu.getLink_users());
        WebFlows.searchAndVerifyUser(user, shouldExist);
    }

    @Test(description = "test08 - Drag And Drop The Title")
    @Description("This Test drag and drop the title and verifies the main header")
    public void test08_dragAndDropHeader() {
        WebFlows.dragAndDropTitle();
        Verifications.verifyTextInElement(grafanaMain.getHead_Dashboard(), "Home Dashboard");
    }

}
