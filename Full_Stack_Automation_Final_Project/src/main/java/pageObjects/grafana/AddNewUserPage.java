package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewUserPage {

    @FindBy(css = "input[ng-model='user.name']")
    private WebElement txt_name;

    @FindBy(css = "input[ng-model='user.email']")
    private WebElement txt_email;

    @FindBy(css = "input[ng-model='user.login']")
    private WebElement txt_userName;

    @FindBy(css = "input[ng-model='user.password']")
    private WebElement txt_password;

    @FindBy(css = "button[type='submit']")
    private WebElement btn_create;

    /**
     * Getter
     * @return
     */
    public WebElement getTxt_name() {
        return txt_name;
    }

    public WebElement getTxt_email() {
        return txt_email;
    }

    public WebElement getTxt_userName() {
        return txt_userName;
    }

    public WebElement getTxt_password() {
        return txt_password;
    }

    public WebElement getBtn_create() {
        return btn_create;
    }
}
