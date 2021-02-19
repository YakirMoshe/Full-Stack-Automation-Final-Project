package pageObjects.todo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class MainPage {

    @FindBy(css = "input[placeholder='Create a task']")
    private WebElement txt_create;

    @FindBy(className = "view_2Ow90")
    private List<WebElement> list_tasks;

    @FindBy(className = "destroy_19w1q")
    private WebElement btn_delete;

    @FindBy(css = "div[class='topWrapper_2caNE']")
    private WebElement btn_dropDownListColor;

    @FindBy(xpath = "//div[2]/div/span[6]")
    private WebElement btn_blueColor;

    @FindBy(xpath = "//div[@class='wrapper_7gdK1']/div/span[1]")
    private WebElement btn_unColor;

    @FindBy(xpath = "(//label//*[name() ='circle'])[2]")
    private WebElement btn_taskMarking;

    @FindBy(xpath = "(//label//*[name() ='path'])")
    private WebElement verifyTaskMarking;



    /**
     * Getter
     * @return
     */
    public WebElement getTxt_create() {
        return txt_create;
    }

    public List<WebElement> getList_tasks() {
        return list_tasks;
    }

    public WebElement getBtn_delete() {
        return btn_delete;
    }

    public WebElement getBtn_dropDownListColor() {
        return btn_dropDownListColor;
    }

    public WebElement getBtn_blueColor() {
        return btn_blueColor;
    }

    public WebElement getBtn_unColor() {
        return btn_unColor;
    }

    public WebElement getBtn_taskMarking() {
        return btn_taskMarking;
    }

    public WebElement getverifyTaskMarking() {
        return verifyTaskMarking;
    }
}


