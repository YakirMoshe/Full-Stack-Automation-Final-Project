package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;

@Listeners(utilities.Listeners.class)
public class TodoListElectron extends CommonOps {

    @Test(description = "test01 - Add And Verify New Task")
    @Description("This Test add a new task and verifies it in the list of tasks")
    public void test01_AddAndVerifyNewTask() {
        ElectronFlows.addNewTask("Learn Java");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks(), 1);
    }

    @Test(description = "test02 - Add And Verify New Task")
    @Description("This Test add a new task and verifies it in the list of tasks")
    public void test02_AddAndVerifyNewTask() {
        ElectronFlows.addNewTask("Learn Java");
        ElectronFlows.addNewTask("Learn C#");
        ElectronFlows.addNewTask("Learn Python");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks(), 3);
    }

    @Test(description = "test03 - Add Task With Blue Color And Verify")
    @Description("This Test add a new task With Blue Color and verifies it in the list of tasks")
    public void test03_AddWithColorAndVerifyNewTask() {
        ElectronFlows.addNewTaskWithColor("Learn PHP");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks(), 1);
    }


    @Test(description = "test04 - Mark a task performed And Verify marking ")
    @Description("This Test Mark a Task and verifies")
    public void test04_MarkTask() {
        ElectronFlows.addNewTask("Learn Automation");
        ElectronFlows.addNewTask("Learn QA");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks(), 2);
        ElectronFlows.markTask();
        Verifications.verifyClickSvgObject(todoMain.getverifyTaskMarking());
    }


}
