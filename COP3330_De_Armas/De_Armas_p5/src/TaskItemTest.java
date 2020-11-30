import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {

    @Test
    public void constuctorFailsWithInvaildDueDate(){
        assertThrows(IllegalArgumentException.class, ()  -> new TaskItem("title","description","20200101",false));
    }

    @Test
    public void constuctorFailsWithInvaildTitle(){
        assertThrows(IllegalArgumentException.class, ()  -> new TaskItem("","description","2020-01-01",false));
    }

    @Test
    public void constuctorSucceedsWithVaildDueDate(){
        TaskItem TaskItems = new TaskItem("name","descript","2000-05-05",false);
    }

    @Test
    public void constuctorSucceedsWithVaildTitle(){
        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
    }

    @Test
    public void editingDescriptionSucceedsWithExpectedValue(){
        ArrayList<TaskItem> TaskItemsTemp = new ArrayList<TaskItem>();

        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
        TaskItemsTemp.add(TaskItems);

        TaskApp.setTaskItemTEST(TaskItemsTemp, 0, "title", "text","2020-01-01",false);
    }

    @Test
    public void editingDueDateFailsWithInvalidDateFormat(){
        ArrayList<TaskItem> TaskItemsTemp = new ArrayList<TaskItem>();

        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
        TaskItemsTemp.add(TaskItems);
        assertThrows(IllegalArgumentException.class, () -> TaskApp.setTaskItemTEST(TaskItemsTemp, 0, "title", "text","20-05-05",false));
    }

    @Test
    public void editingDueDateFailsWithInvalidYYYMDD(){
        ArrayList<TaskItem> TaskItemsTemp = new ArrayList<TaskItem>();

        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
        TaskItemsTemp.add(TaskItems);
        assertThrows(IllegalArgumentException.class, () -> TaskApp.setTaskItemTEST(TaskItemsTemp, 0, "title", "text","200-50-05",false));
    }

    @Test
    public void editingDueDateSucceedsWithValidDate(){
        ArrayList<TaskItem> TaskItemsTemp = new ArrayList<TaskItem>();

        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
        TaskItemsTemp.add(TaskItems);

        TaskApp.setTaskItemTEST(TaskItemsTemp, 0, "title", "text","2050-05-05",false);
    }

    @Test
    public void editingTitleFailsWithInvalidTitle(){
        ArrayList<TaskItem> TaskItemsTemp = new ArrayList<TaskItem>();

        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
        TaskItemsTemp.add(TaskItems);
        assertThrows(IllegalArgumentException.class, () -> TaskApp.setTaskItemTEST(TaskItemsTemp, 0, "", "text","2020-05-05",false));
    }

    @Test
    public void editingTitleSucceedsWithValidTitle(){
        ArrayList<TaskItem> TaskItemsTemp = new ArrayList<TaskItem>();

        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
        TaskItemsTemp.add(TaskItems);

        TaskApp.setTaskItemTEST(TaskItemsTemp, 0, "title", "text","2050-05-05",false);
    }
}
