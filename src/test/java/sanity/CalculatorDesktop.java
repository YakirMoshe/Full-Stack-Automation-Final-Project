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


}


