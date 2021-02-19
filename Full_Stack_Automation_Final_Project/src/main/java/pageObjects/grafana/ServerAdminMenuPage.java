package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServerAdminMenuPage {

    @FindBy(xpath = "//a[@href='/admin/users']")
    private WebElement link_users;

    @FindBy(xpath = "//a[@href='/admin/orgs']")
    private WebElement link_orgs;

    @FindBy(xpath = "//a[@href='/admin/settings']")
    private WebElement link_settings;

    @FindBy(xpath = "//a[@href=' /admin/stats']")
    private WebElement link_stats;

    /**
     * Getter
     * @return
     */
    public WebElement getLink_users() {
        return link_users;
    }

    public WebElement getLink_orgs() {
        return link_orgs;
    }

    public WebElement getLink_settings() {
        return link_settings;
    }

    public WebElement getLink_stats() {
        return link_stats;
    }
}
