package pageObjects.calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    @FindBy(name = "Clear")
    private WebElement btn_clear;

    @FindBy(name = "Zero")
    private WebElement btn_zero;

    @FindBy(name = "One")
    private WebElement btn_one;

    @FindBy(name = "Two")
    private WebElement btn_two;

    @FindBy(name = "Three")
    private WebElement btn_three;

    @FindBy(name = "Four")
    private WebElement btn_four;

    @FindBy(name = "Five")
    private WebElement btn_five;

    @FindBy(name = "Six")
    private WebElement btn_six;

    @FindBy(name = "Seven")
    private WebElement btn_seven;

    @FindBy(name = "Eight")
    private WebElement btn_eight;

    @FindBy(name = "Nine")
    private WebElement btn_nine;

    @FindBy(name = "Plus")
    private WebElement btn_plus;

    @FindBy(name = "Minus")
    private WebElement btn_minus;

    @FindBy(name = "Multiply by")
    private WebElement btn_multiply;

    @FindBy(name = "Divide by")
    private WebElement btn_Divide;

    @FindBy(name = "Equals")
    private WebElement btn_equals;

    @FindBy(xpath = "//*[@AutomationId='CalculatorResults']")
    private WebElement field_result;

    /**
     * Getter
     * @return
     */
    public WebElement getBtn_clear() {
        return btn_clear;
    }

    public WebElement getBtn_zero() {
        return btn_zero;
    }

    public WebElement getBtn_one() {
        return btn_one;
    }

    public WebElement getBtn_two() {
        return btn_two;
    }

    public WebElement getBtn_three() {
        return btn_three;
    }

    public WebElement getBtn_four() {
        return btn_four;
    }

    public WebElement getBtn_five() {
        return btn_five;
    }

    public WebElement getBtn_six() {
        return btn_six;
    }

    public WebElement getBtn_seven() {
        return btn_seven;
    }

    public WebElement getBtn_eight() {
        return btn_eight;
    }

    public WebElement getBtn_nine() {
        return btn_nine;
    }

    public WebElement getBtn_plus() {
        return btn_plus;
    }

    public WebElement getBtn_equals() {
        return btn_equals;
    }

    public WebElement getField_result() {
        return field_result;
    }

    public WebElement getBtn_minus() {
        return btn_minus;
    }

    public WebElement getBtn_multiply() {
        return btn_multiply;
    }

    public WebElement getBtn_Divide() {
        return btn_Divide;
    }
}