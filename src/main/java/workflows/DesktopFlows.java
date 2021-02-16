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
}
