package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class UIActions extends CommonOps {


    @Step("Click on Element")
    public static void click(WebElement elem) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("Click on svgObject")
    public static void clickSvgObject(WebElement elem) {
        action.click(elem).build().perform();
    }

    @Step("Update Text Element")
    public static void updateText(WebElement elem, String text) {
        wait.until((ExpectedConditions.visibilityOf(elem)));
        elem.sendKeys(text);
    }

    @Step("Update Text Element as Human")
    public static void updateTextHuman(WebElement elem, String text) {
        wait.until((ExpectedConditions.visibilityOf(elem)));
        for (char ch : text.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(470, TimeUnit.MILLISECONDS);
            elem.sendKeys(ch + "");
        }
    }

    @Step("Update DropDown Element By Index")
    public static void updateDropDownByIndex(WebElement elem, int index) {
        wait.until((ExpectedConditions.visibilityOf(elem)));
        Select dropDown = new Select(elem);
        dropDown.selectByIndex(index);
    }

    @Step("Update DropDown Element By Text")
    public static void updateDropDownByText(WebElement elem, String text) {
        wait.until((ExpectedConditions.visibilityOf(elem)));
        Select dropDown = new Select(elem);
        dropDown.selectByVisibleText(text);
    }

    @Step("Mouse Hover Element")
    public static void mouseHover(WebElement elem1, WebElement elem2) {
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }


    @Step("Mouse Hover Element")
    public static void mouseHover(WebElement elem1) {
        action.moveToElement(elem1).click().build().perform();
    }

    @Step("Insert Key")
    public static void insertKey(WebElement elem, Keys value) {
        elem.sendKeys(value);
    }


    @Step("drag And Drop Element")
    public static void dragAndDrop(WebElement draggable, WebElement droppable) {
        action.dragAndDrop(draggable, droppable).build().perform();
    }

    @Step("Update DropDown Element By click")
    public static void updateDropDownByClick(WebElement elem,WebElement color) {
        UIActions.click(elem);
        UIActions.click(color);
        UIActions.click(elem);
    }

    @Step("Scroll Down The Page")
    public static void ScrollPage(WebElement elem) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
       js.executeScript("arguments[0].scrollIntoView(true);", elem);
    }

}
