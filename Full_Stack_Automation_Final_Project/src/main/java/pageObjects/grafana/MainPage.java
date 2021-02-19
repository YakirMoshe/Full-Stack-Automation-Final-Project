package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage {
    @FindBy(xpath = "//div[@class='text-center dashboard-header']/span")
    private WebElement head_Dashboard;

    @FindBy(xpath = "//div[@class='progress-tracker']")
    private List<WebElement> list_progressSteps;

    @FindBy(xpath = "//*[@id='panel-1']/div/div/div/plugin-component/panel-plugin-text/grafana-panel/div/div[1]")
    private WebElement btn_panelTitle;

    @FindBy(xpath = "//*[@id='panel-1']/div/div/div/plugin-component/panel-plugin-text/grafana-panel/div/div[1]")
    private WebElement btn_dragTitle;

    @FindBy(xpath = "//div[@id='panel-3']")
    private WebElement btn_dropTitle;


    @FindBy(css = "p[ng-bind-html='ctrl.content']")
    private WebElement scrolled_element;


    /**
     * Getter
     * @return
     */
    public WebElement getHead_Dashboard() {
        return head_Dashboard;
    }

    public List<WebElement> getList_progressSteps() {
        return list_progressSteps;
    }

    public WebElement getBtn_panelTitle() {
        return btn_panelTitle;
    }

    public WebElement getBtn_dragTitle() {
        return btn_dragTitle;
    }

    public WebElement getBtn_dropTitle() {
        return btn_dropTitle;
    }

    public WebElement getScrolled_element() {
        return scrolled_element;
    }
}
