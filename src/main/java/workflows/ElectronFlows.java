package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

public class ElectronFlows extends CommonOps {


    @Step("add New Task to the List")
    public static void addNewTask(String taskName) {
        UIActions.updateText(todoMain.getTxt_create(), taskName);
        UIActions.insertKey(todoMain.getTxt_create(), Keys.RETURN);
    }

    @Step("Count and Return of Tasks in List")
    public static int getNumberOfTasks() {
        return todoMain.getList_tasks().size();  //Returns list size
    }


    @Step("Empty List From Tasks")
    public static void emptyList() {
        for (WebElement task: todoMain.getList_tasks())
        {
            UIActions.mouseHover(todoMain.getBtn_delete());
        }
    }

    @Step("add New Task With Color to the List")
    public static void addNewTaskWithColor(String taskName) {
        UIActions.updateText(todoMain.getTxt_create(), taskName);
        UIActions.updateDropDownByClick(todoMain.getBtn_dropDownListColor(),todoMain.getBtn_blueColor());
        UIActions.click(todoMain.getTxt_create());
        UIActions.insertKey(todoMain.getTxt_create(), Keys.RETURN);
        UIActions.updateDropDownByClick(todoMain.getBtn_dropDownListColor(),todoMain.getBtn_unColor());
    }

    @Step("Mark a task performed")
    public static void markTask() {
        UIActions.clickSvgObject(todoMain.getBtn_taskMarking());
    }

}
