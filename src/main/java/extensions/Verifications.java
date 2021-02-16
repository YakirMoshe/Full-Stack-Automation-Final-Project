package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;

import static org.junit.Assert.fail;
import static org.testng.Assert.*;
import static org.testng.Assert.assertTrue;

import java.util.List;

public class Verifications extends CommonOps {


    @Step("Verify Text In Element")
    public static void verifyTextInElement(WebElement elem, String expected) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expected);
    }

    @Step("Verify Number Of Element")
    public static void numberOfElements(List<WebElement> elems, int expected) {
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size() - 1)));
        assertEquals(elems.size(), expected);
    }

    @Step("Verify Visibility Of Elements (Soft-Assertion)")
    public static void visibilityOfElements(List<WebElement> elems) {
        for (WebElement elem : elems) {
            softAssert.assertTrue(elem.isDisplayed(), "sorry" + elem.getText() + "not displayed");
        }
        //softAssert.assertAll("Some elements were not displayed");
        softAssert.assertAll();
    }

    @Step("Verify Element Visually")
    public static void visualElement(String expectedImageName) {
        try {
            screen.find(getData("ImageRepo") + expectedImageName + ".png");
        } catch (FindFailed findFailed) {
            System.out.println("Error Conparing Image File: " + findFailed);
            fail("Error Conparing Image File: " + findFailed);
        }
    }

    @Step("Verify Element Displayed")
    public static void existanceOfElement(List<WebElement> elements) {
        assertTrue(elements.size() > 0); //Checks if the list is empty or not
    }

    @Step("Verify Element Not Displayed")
    public static void nonExistanceOfElement(List<WebElement> elements) {
        assertFalse(elements.size() > 0); //Checks if the list is empty or not
    }

    @Step("Verify actual Text with Expected Text")
    public static void verifyText(String actual, String expected) {
        assertEquals(actual, expected);
    }

    @Step("Verify actual Number with Expected Number")
    public static void verifyNumber(int actual, int expected) {
        assertEquals(actual, expected);
    }

    @Step("Verify the svgobject check")
    public static void verifyClickSvgObject(WebElement elem) {
         assertTrue(elem.isDisplayed() , "Oh no, The Task is not Marked");
    }
}
