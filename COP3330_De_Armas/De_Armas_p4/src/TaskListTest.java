import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {

    @Test
    public void addingTaskItemsIncreasesSize(){
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
        String firstVal = App.getTaskItemStringValueTEST(TaskItemsTest,0,4);
        App.setTaskItemTEST(TaskItemsTest,0,App.getTaskItemStringValueTEST(TaskItemsTest,0,1),App.getTaskItemStringValueTEST(TaskItemsTest,0,2),App.getTaskItemStringValueTEST(TaskItemsTest,0,3),true);
        String secondVal = App.getTaskItemStringValueTEST(TaskItemsTest,0,4);

        assertNotEquals(firstVal, secondVal);
    }

    @Test
    public void  completingTaskItemFailsWithInvalidIndex(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(TaskItems);
        String firstVal = App.getTaskItemStringValueTEST(TaskItemsTest,0,4);
        assertThrows(IndexOutOfBoundsException.class, () -> App.removeTaskItemTEST(TaskItemsTest, 5));
    }

    @Test
    public void editingTaskItemChangesValues(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(TaskItems);
        String firstVal = App.getTaskItemStringValueTEST(TaskItemsTest,0,1);

        App.setTaskItemTEST(TaskItemsTest, 0, "text", "description","2020-01-01",false);
        String secondVal = App.getTaskItemStringValueTEST(TaskItemsTest,0,1);

        assertNotEquals(firstVal, secondVal);
    }

    @Test
    public void editingTaskItemDescriptionChangesValue(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(TaskItems);
        String firstVal = App.getTaskItemStringValueTEST(TaskItemsTest,0,2);

        App.setTaskItemTEST(TaskItemsTest, 0, "title", "text","2020-01-01",false);
        String secondVal = App.getTaskItemStringValueTEST(TaskItemsTest,0,2);

        assertNotEquals(firstVal, secondVal);
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(TaskItems);
        String firstVal = App.getTaskItemStringValueTEST(TaskItemsTest,0,2);

        App.setTaskItemTEST(TaskItemsTest, 0, "title", "text","2020-01-01",false);
        assertThrows(IndexOutOfBoundsException.class, () -> App.setTaskItemTEST(TaskItemsTest, 5, "title", "text","2020-05-05",false));
    }

    @Test
    public void editingTaskItemDueDateChangesValue(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(TaskItems);
        String firstVal = App.getTaskItemStringValueTEST(TaskItemsTest,0,3);

        App.setTaskItemTEST(TaskItemsTest, 0, "title", "description","2050-01-01",false);
        String secondVal = App.getTaskItemStringValueTEST(TaskItemsTest,0,3);

        assertNotEquals(firstVal, secondVal);
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(TaskItems);
        String firstVal = App.getTaskItemStringValueTEST(TaskItemsTest,0,3);

        App.setTaskItemTEST(TaskItemsTest, 0, "title", "description","2020-05-05",false);
        assertThrows(IndexOutOfBoundsException.class, () -> App.setTaskItemTEST(TaskItemsTest, 5, "title", "text","2020-05-05",false));
    }

    @Test
    public void editingTaskItemTitleChangesValue(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(TaskItems);
        String firstVal = App.getTaskItemStringValueTEST(TaskItemsTest,0,1);

        App.setTaskItemTEST(TaskItemsTest, 0, "text", "description","2020-01-01",false);
        String secondVal = App.getTaskItemStringValueTEST(TaskItemsTest,0,1);

        assertNotEquals(firstVal, secondVal);
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(TaskItems);
        String firstVal = App.getTaskItemStringValueTEST(TaskItemsTest,0,2);

        App.setTaskItemTEST(TaskItemsTest, 0, "text", "description","2020-01-01", false);
        assertThrows(IndexOutOfBoundsException.class, () -> App.setTaskItemTEST(TaskItemsTest, 5, "title", "text","2020-05-05", false));
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem ItemTest = new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(ItemTest);

        assertThrows(IndexOutOfBoundsException.class, () -> App.getTaskItemValueTEST(TaskItemsTest,5,2));
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem ItemTest = new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(ItemTest);

        assertEquals("description", App.getTaskItemStringValueTEST(TaskItemsTest,0,2));
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem ItemTest = new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(ItemTest);

        assertThrows(IndexOutOfBoundsException.class, () -> App.getTaskItemValueTEST(TaskItemsTest,5,3));
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem ItemTest = new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(ItemTest);

        assertEquals("2020-01-01", App.getTaskItemStringValueTEST(TaskItemsTest,0,3));
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem ItemTest = new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(ItemTest);

        assertThrows(IndexOutOfBoundsException.class, () -> App.getTaskItemValueTEST(TaskItemsTest,5,1));
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem ItemTest = new TaskItem("title","description","2020-01-01",false);
        TaskItemsTest.add(ItemTest);

        assertEquals("title", App.getTaskItemStringValueTEST(TaskItemsTest,0,1));
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

        assertThrows(IndexOutOfBoundsException.class, () -> App.removeTaskItemTEST(TaskItemsTest, 5));
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
        String firstVal = App.getTaskItemStringValueTEST(TaskItemsTest,0,4);
        App.setTaskItemTEST(TaskItemsTest,0,App.getTaskItemStringValueTEST(TaskItemsTest,0,1),App.getTaskItemStringValueTEST(TaskItemsTest,0,2),App.getTaskItemStringValueTEST(TaskItemsTest,0,3),false);
        String secondVal = App.getTaskItemStringValueTEST(TaskItemsTest,0,4);

        assertNotEquals(firstVal, secondVal);
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex(){
        ArrayList<TaskItem> TaskItemsTest = new ArrayList<TaskItem>();
        TaskItem TaskItems =  new TaskItem("title","description","2020-01-01",true);
        TaskItemsTest.add(TaskItems);
        String firstVal = App.getTaskItemStringValueTEST(TaskItemsTest,0,4);
        assertThrows(IndexOutOfBoundsException.class, () -> App.removeTaskItemTEST(TaskItemsTest, 5));
    }
}
