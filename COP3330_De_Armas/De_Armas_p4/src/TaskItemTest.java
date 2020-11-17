import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {

    @Test
    public void creatingTaskItemFailsWithInvaildDueDate(){
        assertThrows(IllegalArgumentException.class, ()  -> new TaskItem("title","description","20200101",false));
    }

    @Test
    public void creatingTaskItemFailsWithInvaildTitle(){
        assertThrows(IllegalArgumentException.class, ()  -> new TaskItem("","description","2020-01-01",false));
    }

    @Test
    public void creatingTaskItemSucceedsWithVaildDueDate(){
        TaskItem TaskItems = new TaskItem("name","descript","2000-05-05",false);
    }

    @Test
    public void creatingTaskItemSucceedsWithVaildTitle(){
        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate(){
        ArrayList<TaskItem> TaskItemsTemp = new ArrayList<TaskItem>();

        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
        TaskItemsTemp.add(TaskItems);
        assertThrows(IllegalArgumentException.class, () -> App.setTaskItemTEST(TaskItemsTemp, 0, "title", "text","20-05-05",false));
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate(){
        ArrayList<TaskItem> TaskItemsTemp = new ArrayList<TaskItem>();

        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
        TaskItemsTemp.add(TaskItems);

        App.setTaskItemTEST(TaskItemsTemp, 0, "title", "text","2050-05-05",false);
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle(){
        ArrayList<TaskItem> TaskItemsTemp = new ArrayList<TaskItem>();

        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
        TaskItemsTemp.add(TaskItems);
        assertThrows(IllegalArgumentException.class, () -> App.setTaskItemTEST(TaskItemsTemp, 0, "", "text","2020-05-05",false));
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle(){
        ArrayList<TaskItem> TaskItemsTemp = new ArrayList<TaskItem>();

        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
        TaskItemsTemp.add(TaskItems);

        App.setTaskItemTEST(TaskItemsTemp, 0, "title", "text","2050-05-05",false);
    }
}
