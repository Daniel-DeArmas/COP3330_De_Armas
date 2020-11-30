import java.util.ArrayList;

public class TaskList {
    ArrayList<TaskItem> TaskItems = new ArrayList<TaskItem>();
    String name;

    public TaskList(String listName, ArrayList<TaskItem> TaskItemsTemp) {
        this.name = listName;
        this.TaskItems = TaskItemsTemp;
    }
}
