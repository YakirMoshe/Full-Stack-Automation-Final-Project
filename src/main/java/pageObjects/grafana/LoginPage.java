package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(name = "user")
    private WebElement txt_username;

    @FindBy(name = "password")
    private WebElement txt_password;

    @FindBy(css = "button[type='submit']")
    private WebElement btn_login;

    @FindBy(xpath = "//a[contains(text(),'Skip')]")
    private WebElement btn_skip;

    /**
     * Getter
     * @return
     */
    public WebElement getTxt_username() {
        return txt_username;
    }

    public WebElement getTxt_password() {
        return txt_password;
    }

    public WebElement getBtn_login() {
        return btn_login;
    }

    public WebElement getBtn_skip() {
        return btn_skip;
    }
}
