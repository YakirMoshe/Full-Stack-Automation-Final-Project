package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;

@Listeners(utilities.Listeners.class)
public class GrafanaAPI extends CommonOps {

    @Test(description = "test01 - Get Team From Grafana API")
    @Description("This Test verifies Team Property")
    public void test01_verifyTeam() {
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[0].name"), "YakirTeam");
    }

    @Test(description = "test02 - Add Team and Verify in Grafana API")
    @Description("This Test Add a Team Property and verify")
    public void test02_addTeamAndVerify() {
        ApiFlows.postTeam("Znetafim", "netafim@gmail.com");
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[1].name"), "Znetafim");
    }

    @Test(description = "test03 - Update Team and Verify")
    @Description("This Test Update a Team in Grafana and Verify it")
    public void test03_updateTeamAndVerify() {
        String id = ApiFlows.getTeamProperty("teams[1].id");
        ApiFlows.updateTeam("Znetafim", "mor@netafim.com", id);
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[1].email"), "mor@netafim.com");
    }

    @Test(description = "test04 - Delete Team and Verify")
    @Description("This Test Deletes a Team in Grafana and Verify it")
    public void test04_deleteTeamAndVerify() {
        String id = ApiFlows.getTeamProperty("teams[1].id");
        ApiFlows.deleteTeam(id);
        Verifications.verifyText(ApiFlows.getTeamProperty("totalCount"), "1");
    }


}
