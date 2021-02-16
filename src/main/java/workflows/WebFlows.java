package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.DBactions;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import utilities.CommonOps;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class WebFlows extends CommonOps {

    @Step("Business Flow: Login to Grafana")
    public static void login(String user, String pass) {
        UIActions.updateText(grafanaLogin.getTxt_username(), user);
        UIActions.updateText(grafanaLogin.getTxt_password(), pass);
        UIActions.click(grafanaLogin.getBtn_login());
        UIActions.click(grafanaLogin.getBtn_skip());
    }

    @Step("Business Flow: Login to Grafana with DB Credentials")
    public static void loginDB() {
        String query = "SELECT name,password FROM Employees WHERE id = '3'";
        List<String> cred = DBactions.getCredentials(query);
        UIActions.updateText(grafanaLogin.getTxt_username(), cred.get(0));
        UIActions.updateText(grafanaLogin.getTxt_password(), cred.get(1));
        UIActions.click(grafanaLogin.getBtn_login());
        UIActions.click(grafanaLogin.getBtn_skip());
    }

    @Step("Business Flow: Create New User")
    public static void createNewUser(String name, String email, String username, String password) {
        UIActions.click(grafanaServerAdminMain.getBtn_newUser());
        UIActions.updateText(grafanaAddNewUser.getTxt_name(), name);
        UIActions.updateText(grafanaAddNewUser.getTxt_email(), email);
        UIActions.updateText(grafanaAddNewUser.getTxt_userName(), username);
        UIActions.updateText(grafanaAddNewUser.getTxt_password(), password);
        UIActions.click(grafanaAddNewUser.getBtn_create());
    }

    @Step("Business Flow: Delete Last User")
    public static void deleteLastUser() {
        UIActions.click(grafanaServerAdminMain.getRows().get(grafanaServerAdminMain.getRows().size() - 1));
        UIActions.click(grafanaEditUser.getBtn_deleteUser());
        UIActions.click(grafanaEditUser.getBtn_confirmdDeleteUser());
    }

    @Step("Business Flow: Search And Verify User")
    public static void searchAndVerifyUser(String user, String shouldExists) {
        UIActions.updateTextHuman(grafanaServerAdminMain.getTxt_search(), user);
        if (shouldExists.equalsIgnoreCase("exists"))
            Verifications.existanceOfElement(grafanaServerAdminMain.getRows());
        else if (shouldExists.equalsIgnoreCase("not-exist"))
            Verifications.nonExistanceOfElement(grafanaServerAdminMain.getRows());
        else
            throw new RuntimeException("Invalid Expected Output Option in Data Driven testing , should be exists or not-exist");
    }

    @Step("Business Flow: Drag And Drop The Title")
    public static void dragAndDropTitle() {
        UIActions.mouseHover(grafanaMain.getBtn_panelTitle());
        UIActions.dragAndDrop(grafanaMain.getBtn_dragTitle(),grafanaMain.getBtn_dropTitle());
        UIActions.ScrollPage(grafanaMain.getScrolled_element());
        UIActions.click(grafanaMain.getBtn_panelTitle());
        Uninterruptibles.sleepUninterruptibly(3,TimeUnit.SECONDS);
    }
}
