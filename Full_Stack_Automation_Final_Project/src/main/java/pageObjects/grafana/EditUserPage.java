package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditUserPage {
    @FindBy(css =  "button[ng-click='deleteUser(user)")
    private WebElement btn_deleteUser;

    @FindBy(css =  "button[ng-show='onConfirm")
    private WebElement btn_confirmdDeleteUser;

    /**
     * Getter
     * @return
     */
    public WebElement getBtn_deleteUser() {
        return btn_deleteUser;
    }

    public WebElement getBtn_confirmdDeleteUser() {
        return btn_confirmdDeleteUser;
    }
}
