package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlows;

@Listeners(utilities.Listeners.class)
public class CalculatorDesktop extends CommonOps {

    @Test(description = "test01 - Verify Addition Command")
    @Description("This Test Verify Addition Command")
    public void test01_verifyAdditionCommand() {
        DesktopFlows.calculateAddition();
        Verifications.verifyTextInElement(calcMain.getField_result(), "Display is 9");
    }

    @Test(description = "test02 - Verify the subtraction Command")
    @Description("This Test Verify subtraction Command")
    public void test02_verifySubtractionCommand() {
        DesktopFlows.CalculateMinus();
        Verifications.verifyTextInElement(calcMain.getField_result(), "Display is 3");
    }

    @Test(description = "test03 - Verify the multiplication Command")
    @Description("This Test Verify multiplication Command")
    public void test03_verifyMultiplicationCommand() {
        DesktopFlows.CalculateMultiply();
        Verifications.verifyTextInElement(calcMain.getField_result(), "Display is 21");
    }

    @Test(description = "test04 - Verify the Division Command")
    @Description("This Test Verify Division Command")
    public void test04_verifyDivisionCommand() {
        DesktopFlows.CalculateDivide();
        Verifications.verifyTextInElement(calcMain.getField_result(), "Display is 8");
    }

}


