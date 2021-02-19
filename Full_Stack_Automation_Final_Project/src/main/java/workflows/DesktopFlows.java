package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class DesktopFlows extends CommonOps {

    @Step("Calculate Addition: 1 + 8")
    public static void calculateAddition() {
        UIActions.click(calcMain.getBtn_clear());
        UIActions.click(calcMain.getBtn_one());
        UIActions.click(calcMain.getBtn_plus());
        UIActions.click(calcMain.getBtn_eight());
        UIActions.click(calcMain.getBtn_equals());
    }

    @Step("Calculate Subtraction: 5 - 2")
    public static void CalculateMinus() {
        UIActions.click(calcMain.getBtn_clear());
        UIActions.click(calcMain.getBtn_five());
        UIActions.click(calcMain.getBtn_minus());
        UIActions.click(calcMain.getBtn_two());
        UIActions.click(calcMain.getBtn_equals());
    }

    @Step("Calculate Multiplication: 7 * 3")
    public static void CalculateMultiply() {
        UIActions.click(calcMain.getBtn_clear());
        UIActions.click(calcMain.getBtn_seven());
        UIActions.click(calcMain.getBtn_multiply());
        UIActions.click(calcMain.getBtn_three());
        UIActions.click(calcMain.getBtn_equals());
    }

    @Step("Calculate Division: 16 / 2")
    public static void CalculateDivide() {
        UIActions.click(calcMain.getBtn_clear());
        UIActions.click(calcMain.getBtn_one());
        UIActions.click(calcMain.getBtn_six());
        UIActions.click(calcMain.getBtn_Divide());
        UIActions.click(calcMain.getBtn_two());
        UIActions.click(calcMain.getBtn_equals());
    }

}
