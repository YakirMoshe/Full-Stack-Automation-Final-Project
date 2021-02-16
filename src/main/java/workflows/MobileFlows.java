package workflows;

import extensions.MobileActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class MobileFlows  extends CommonOps {

    @Step("Business Flow: Fill From and Calculate Mortgage")
    public static void calculateMortgage(String amount, String term, String rate) {
        MobileActions.updateText(mortgageMain.getTxt_amount(), amount);
        MobileActions.updateText(mortgageMain.getTxt_term(), term);
        MobileActions.updateText(mortgageMain.getTxt_rate(), rate);
        MobileActions.click(mortgageMain.getBtn_Calculate());
        //MobileActions.tap(1, mortgageMain.getBtn_Calculate, 500);
    }

}
