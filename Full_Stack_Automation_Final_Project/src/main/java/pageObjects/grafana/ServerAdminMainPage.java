package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ServerAdminMainPage {

    @FindBy(css = "tr[ng-repeat='user in ctrl.users']")
    private List<WebElement> rows;

    @FindBy(css = "a[class='btn btn-primary']")
    private WebElement btn_newUser;


    @FindBy(css = "input[ng-model='ctrl.query']")
    private WebElement txt_search;

    /**
     * Getter
     * @return
     */
    public List<WebElement> getRows() {
        return rows;
    }

    public WebElement getBtn_newUser() {
        return btn_newUser;
    }

    public WebElement getTxt_search() {
        return txt_search;
    }
}
