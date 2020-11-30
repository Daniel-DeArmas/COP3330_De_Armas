import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {

    @Test
    public void addingItemsIncreasesSize(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem ItemTest = new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(ItemTest);
        int first = TaskItemsTest.size();

        ItemTest = new TaskItem("title2","description2","2020-01-02",false);
        TaskItemsTest.add(ItemTest);
        int second = TaskItemsTest.size();

        assertEquals(first+1,second);
    }

    @Test
    public void completingTaskItemChangesStatus(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(TaskItems);
        String firstVal = TaskApp.getTaskItemStringValueTEST(TaskItemsTest,0,4);
        TaskApp.setTaskItemTEST(TaskItemsTest,0,TaskApp.getTaskItemStringValueTEST(TaskItemsTest,0,1),TaskApp.getTaskItemStringValueTEST(TaskItemsTest,0,2),TaskApp.getTaskItemStringValueTEST(TaskItemsTest,0,3),true);
        String secondVal = TaskApp.getTaskItemStringValueTEST(TaskItemsTest,0,4);

        assertNotEquals(firstVal, secondVal);
    }

    @Test
    public void  completingTaskItemFailsWithInvalidIndex(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(TaskItems);
        String firstVal = TaskApp.getTaskItemStringValueTEST(TaskItemsTest,0,4);
        assertThrows(IndexOutOfBoundsException.class, () -> TaskApp.removeTaskItemTEST(TaskItemsTest, 5));
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(TaskItems);
        String firstVal = TaskApp.getTaskItemStringValueTEST(TaskItemsTest,0,2);

        TaskApp.setTaskItemTEST(TaskItemsTest, 0, "title", "text","2020-01-01",false);
        assertThrows(IndexOutOfBoundsException.class, () -> TaskApp.setTaskItemTEST(TaskItemsTest, 5, "title", "text","2020-05-05",false));
    }

    @Test
    public void editingItemDescriptionSucceedsWithExpectedValue(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(TaskItems);
        String firstVal = TaskApp.getTaskItemStringValueTEST(TaskItemsTest,0,2);

        TaskApp.setTaskItemTEST(TaskItemsTest, 0, "title", "text","2020-01-01",false);
        String secondVal = TaskApp.getTaskItemStringValueTEST(TaskItemsTest,0,2);

        assertNotEquals(firstVal, secondVal);
    }

    @Test
    public void editingItemDueDateSucceedsWithExpectedValue(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(TaskItems);
        String firstVal = TaskApp.getTaskItemStringValueTEST(TaskItemsTest,0,3);

        TaskApp.setTaskItemTEST(TaskItemsTest, 0, "title", "description","2050-01-01",false);
        String secondVal = TaskApp.getTaskItemStringValueTEST(TaskItemsTest,0,3);

        assertNotEquals(firstVal, secondVal);
    }

    @Test
    public void editingItemTitleFailsWithEmptyString(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(TaskItems);

        assertThrows(IllegalArgumentException.class, () -> TaskApp.setTaskItemTEST(TaskItemsTest, 0, "", "description","2020-05-05", false));
    }

    @Test
    public void editingItemTitleFailsWithInvalidIndex(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(TaskItems);
        String firstVal = TaskApp.getTaskItemStringValueTEST(TaskItemsTest,0,2);

        TaskApp.setTaskItemTEST(TaskItemsTest, 0, "text", "description","2020-01-01", false);
        assertThrows(IndexOutOfBoundsException.class, () -> TaskApp.setTaskItemTEST(TaskItemsTest, 5, "title", "text","2020-05-05", false));
    }

    @Test
    public void editingItemTitleSucceedsWithExpectedValue(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(TaskItems);
        String firstVal = TaskApp.getTaskItemStringValueTEST(TaskItemsTest,0,1);

        TaskApp.setTaskItemTEST(TaskItemsTest, 0, "text", "description","2020-01-01",false);
        String secondVal = TaskApp.getTaskItemStringValueTEST(TaskItemsTest,0,1);

        assertNotEquals(firstVal, secondVal);
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidDateFormat(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(TaskItems);

        assertThrows(IllegalArgumentException.class, () -> TaskApp.setTaskItemTEST(TaskItemsTest, 0, "title", "text","20200505",false));
    }

    @Test
    public void editingItemDueDateFailsWithInvalidIndex(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(TaskItems);
        String firstVal = TaskApp.getTaskItemStringValueTEST(TaskItemsTest,0,3);

        TaskApp.setTaskItemTEST(TaskItemsTest, 0, "title", "description","2020-05-05",false);
        assertThrows(IndexOutOfBoundsException.class, () -> TaskApp.setTaskItemTEST(TaskItemsTest, 5, "title", "text","2020-05-05",false));
    }

    @Test
    public void editingItemDueDateFailsWithInvalidYYYMMDD(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(TaskItems);

        assertThrows(IllegalArgumentException.class, () -> TaskApp.setTaskItemTEST(TaskItemsTest, 0, "title", "text","202-50-05",false));
    }

    @Test
    public void gettingItemDescriptionFailsWithInvalidIndex(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem ItemTest = new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(ItemTest);

        assertThrows(IndexOutOfBoundsException.class, () -> TaskApp.getTaskItemValueTEST(TaskItemsTest,5,2));
    }

    @Test
    public void gettingItemDescriptionSucceedsWithValidIndex(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem ItemTest = new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(ItemTest);

        assertEquals("description", TaskApp.getTaskItemStringValueTEST(TaskItemsTest,0,2));
    }

    @Test
    public void gettingItemDueDateFailsWithInvalidIndex(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem ItemTest = new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(ItemTest);

        assertThrows(IndexOutOfBoundsException.class, () -> TaskApp.getTaskItemValueTEST(TaskItemsTest,5,3));
    }

    @Test
    public void gettingItemDueDateSucceedsWithValidIndex(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem ItemTest = new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(ItemTest);

        assertEquals("2020-01-01", TaskApp.getTaskItemStringValueTEST(TaskItemsTest,0,3));
    }

    @Test
    public void gettingItemTitleFailsWithInvalidIndex(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem ItemTest = new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(ItemTest);

        assertThrows(IndexOutOfBoundsException.class, () -> TaskApp.getTaskItemValueTEST(TaskItemsTest,5,1));
    }

    @Test
    public void gettingItemTitleSucceedsWithValidIndex(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem ItemTest = new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(ItemTest);

        assertEquals("title", TaskApp.getTaskItemStringValueTEST(TaskItemsTest,0,1));
    }

    @Test
    public void newTaskListIsEmpty(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        assertEquals(TaskItemsTest.size(), 0);
    }

    @Test
    public void removingTaskItemsDecreasesSize(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem ItemTest = new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(ItemTest);
        ItemTest = new TaskItem("title2","description2","2020-01-02",false);
        TaskItemsTest.add(ItemTest);
        int first = TaskItemsTest.size();

        TaskItemsTest.remove(0);
        int second = TaskItemsTest.size();

        assertEquals(first,second+1);
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem ItemTest = new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(ItemTest);

        assertThrows(IndexOutOfBoundsException.class, () -> TaskApp.removeTaskItemTEST(TaskItemsTest, 5));
    }

    @Test
    public void savedTaskListCanBeLoaded(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        ArrayList<TaskList> TaskLists = new ArrayList<TaskList>();
        TaskItem ItemTest = new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(ItemTest);
        TaskList ItemsTest = new TaskList("title",TaskItemsTest);
        TaskLists.add(ItemsTest);
        assertEquals(TaskItemsTest, TaskLists.get(0).TaskItems);
    }

    @Test
    public void uncompletingTaskItemChangesStatus(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",true);
        TaskItemsTest.add(TaskItems);
        String firstVal = TaskApp.getTaskItemStringValueTEST(TaskItemsTest,0,4);
        TaskApp.setTaskItemTEST(TaskItemsTest,0,TaskApp.getTaskItemStringValueTEST(TaskItemsTest,0,1),TaskApp.getTaskItemStringValueTEST(TaskItemsTest,0,2),TaskApp.getTaskItemStringValueTEST(TaskItemsTest,0,3),false);
        String secondVal = TaskApp.getTaskItemStringValueTEST(TaskItemsTest,0,4);

        assertNotEquals(firstVal, secondVal);
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",true);
        TaskItemsTest.add(TaskItems);
        String firstVal = TaskApp.getTaskItemStringValueTEST(TaskItemsTest,0,4);
        assertThrows(IndexOutOfBoundsException.class, () -> TaskApp.removeTaskItemTEST(TaskItemsTest, 5));
    }
}
