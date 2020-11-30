import com.sun.source.tree.WhileLoopTree;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskApp {

    public static void main(ArrayList<TaskList> TaskLists) {
        //ArrayList<TaskList> TaskLists = new ArrayList<TaskList>();

        int x = 0;
        while(x!=3) {
            printMainMenu();
            x = getInt();

            if (x == 1) {
                createList(TaskLists);
            } else if (x == 2) {
                loadList(TaskLists);
            } else if(x==3){
                System.out.println("END");
            }else{
                System.out.println("Value entered is invalid. Please Try Again.");
            }
        }
    }

    public static int getInt(){
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        return x;
    }

    public static String getString(){
        Scanner scan = new Scanner(System.in);
        String x = scan.next();
        return x;
    }

    public static void createList(ArrayList<TaskList> TaskLists){
        ArrayList<TaskItem> TaskItemsTemp = new ArrayList<TaskItem>();

        int x=0;

        while(x!=8){
            printListOpMenu();
            x = getInt();
            if (x == 1) {
                printTaskItems(TaskItemsTemp);
            } else if (x == 2) {
                listOpAddItem(TaskItemsTemp);
            } else if (x == 3) {
                printTaskItems(TaskItemsTemp);
                listOpEditItem(TaskItemsTemp);
            } else if (x == 4) {
                printTaskItems(TaskItemsTemp);
                listOpRemoveItem(TaskItemsTemp);
            } else if (x == 5) {
                listOpMarkComplete(TaskItemsTemp);
            } else if (x == 6) {
                listOpUnmarkComplete(TaskItemsTemp);
            } else if (x == 7) {
                listOpSaveList(TaskItemsTemp, TaskLists);
            } else if (x == 8) {
                //back to main menu
            } else {
                System.out.println("Value entered is invalid. Please Try Again.");
            }
        }
    }

    public static void loadList(ArrayList<TaskList> TaskLists){
        ArrayList<TaskItem> TaskItemsTemp = null;
        System.out.println("Current Tasks");
        System.out.println("-------------");
        System.out.println("");
        for(int i = 0; i < TaskLists.size(); i++) {
            System.out.println(i + ") " + TaskLists.get(i).name);
        }
        System.out.println("");
        System.out.println("Enter the file name to load: ");
        String z = getString();

        int x=0;
        int y=-1;
        for(int i = 0; i < TaskLists.size(); i++) {
            if (TaskLists.get(i).name.equals(z)) {
                y = i;
            }
        }

        if(y==-1){
            x=8;
        }

        try{
            TaskItemsTemp = TaskLists.get(y).TaskItems;
        }catch (IndexOutOfBoundsException e){
            System.out.println("Warning: TasksLists is empty or File dosen't exist");
            System.out.println("");
        }

        while(x!=8){
            printListOpMenu();
            x = getInt();
            if (x == 1) {
                printTaskItems(TaskItemsTemp);
            } else if (x == 2) {
                listOpAddItem(TaskItemsTemp);
            } else if (x == 3) {
                printTaskItems(TaskItemsTemp);
                listOpEditItem(TaskItemsTemp);
            } else if (x == 4) {
                printTaskItems(TaskItemsTemp);
                listOpRemoveItem(TaskItemsTemp);
            } else if (x == 5) {
                listOpMarkComplete(TaskItemsTemp);
            } else if (x == 6) {
                listOpUnmarkComplete(TaskItemsTemp);
            } else if (x == 7) {
                z = TaskLists.get(y).name;
                TaskList List = new TaskList(z, TaskItemsTemp);
                TaskLists.set(y, List);
                System.out.println("task list has been saved");
            } else if (x == 8) {
                //back to main menu
            } else {
                System.out.println("Value entered is invalid. Please Try Again.");
            }
        }
    }

    public static void printTaskItems(ArrayList<TaskItem> TaskItemsTemp){
        System.out.println("Current Tasks");
        System.out.println("-------------");
        System.out.println("");
        for(int i = 0; i < TaskItemsTemp.size(); i++) {
            if(TaskItemsTemp.get(i).completed==true){
                System.out.print("*** ");
            }
            System.out.println(i+") ["+TaskItemsTemp.get(i).dueDate+"] "+TaskItemsTemp.get(i).title+": "+TaskItemsTemp.get(i).description);
        }
        System.out.println("");
    }

    public static void printMainMenu(){
        System.out.println("Main Menu");
        System.out.println("---------");
        System.out.println("");
        System.out.println("1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit");
        System.out.println("");
    }

    public static void printListOpMenu(){
        System.out.println("List Operation Menu");
        System.out.println("---------");
        System.out.println("");
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) mark an item as completed");
        System.out.println("6) unmark an item as completed");
        System.out.println("7) save the current list");
        System.out.println("8) quit to the main menu");
        System.out.println("");
    }

    public static void listOpAddItem(ArrayList<TaskItem> TaskItemsTemp) {
        System.out.print("Task title: ");
        String title = getString();
        System.out.print("Task description: ");
        String description = getString();
        System.out.print("Task due date (YYYY-MM-DD): ");
        String dueDate = getString();
        System.out.println("");

        try {
            TaskItem Task = new TaskItem(title, description, dueDate, false);
            TaskItemsTemp.add(Task);
        }catch(IllegalArgumentException e){
            System.out.println("WARNING: title must be at least 1 character long and/or due date was input wrong; task not created");
        }
    }

    public static void listOpEditItem(ArrayList<TaskItem> TaskItemsTemp){
        System.out.println("Which task will you edit?");
        int y = getInt();
        System.out.print("Enter a new title for task "+y+": ");
        String title = getString();
        System.out.print("Enter a new description for task "+y+": ");
        String description = getString();
        System.out.print("Enter a new due date (YYYY-MM-DD) for task "+y+": ");
        String dueDate = getString();
        System.out.println("");
        try {
            TaskItem Task = new TaskItem(title, description, dueDate, false);
            TaskItemsTemp.set(y,Task);
        }catch(IllegalArgumentException e){
            System.out.println("WARNING: title must be at least 1 character long and/or due date was input wrong; edit cancelled");
        }catch (IndexOutOfBoundsException e){
            System.out.println("Warning: invalid task selected, edit cancelled");
        }
    }

    public static void listOpRemoveItem(ArrayList<TaskItem> TaskItemsTemp){
        System.out.println("Which task will you remove?");
        int y = getInt();
        try{
            TaskItemsTemp.remove(y);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Warning: no task was selected, nothing was removed");
        }
    }

    public static void listOpMarkComplete(ArrayList<TaskItem> TaskItemsTemp){
        System.out.println("Uncompleted Tasks");
        System.out.println("-------------");
        System.out.println("");
        for(int i = 0; i < TaskItemsTemp.size(); i++) {
            if(TaskItemsTemp.get(i).completed==false){
                System.out.println(i+") ["+TaskItemsTemp.get(i).dueDate+"] "+TaskItemsTemp.get(i).title+": "+TaskItemsTemp.get(i).description);
            }
        }
        System.out.println("");
        System.out.println("Which task will you mark as completed?");
        int y = getInt();
        try {
            TaskItem Task = new TaskItem(TaskItemsTemp.get(y).title, TaskItemsTemp.get(y).description, TaskItemsTemp.get(y).dueDate, true);
            TaskItemsTemp.set(y, Task);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Warning: no task was selected, nothing was marked");
        }
    }

    public static void listOpUnmarkComplete(ArrayList<TaskItem> TaskItemsTemp) {
        System.out.println("Completed Tasks");
        System.out.println("-------------");
        System.out.println("");
        for (int i = 0; i < TaskItemsTemp.size(); i++) {
            if (TaskItemsTemp.get(i).completed == true) {
                System.out.println(i + ") [" + TaskItemsTemp.get(i).dueDate + "] " + TaskItemsTemp.get(i).title + ": " + TaskItemsTemp.get(i).description);
            }
        }
        System.out.println("");
        System.out.println("Which task will you unmark as completed?");
        int y = getInt();
        try {
            TaskItem Task = new TaskItem(TaskItemsTemp.get(y).title, TaskItemsTemp.get(y).description, TaskItemsTemp.get(y).dueDate, false);
            TaskItemsTemp.set(y, Task);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Warning: no task was selected, nothing was unmarked");
        }
    }

    public static void listOpSaveList(ArrayList<TaskItem> TaskItemsTemp, ArrayList<TaskList> TaskLists){
        System.out.println("Enter the filename to save as: ");
        String z = getString();
        TaskList List = new TaskList(z, TaskItemsTemp);
        TaskLists.add(List);
        System.out.println("task list has been saved");
    }

    public static void setTaskItemTEST(ArrayList<TaskItem> TaskItemsTemp, int index, String title, String description, String dueDate, boolean completed){
        TaskItem Task = new TaskItem(title, description, dueDate, completed);
        TaskItemsTemp.set(index,Task);
    }

    public static void getTaskItemValueTEST(ArrayList<TaskItem> TaskItemsTemp, int index, int valSelector){
        String val;
        if(valSelector==1){
            val=TaskItemsTemp.get(index).title;
            System.out.println(""+val+"");
        }else if(valSelector==2){
            val=TaskItemsTemp.get(index).description;
            System.out.println(""+val+"");
        }else if(valSelector==3){
            val=TaskItemsTemp.get(index).dueDate;
            System.out.println(""+val+"");
        }else{
            boolean valBool=TaskItemsTemp.get(index).completed;
            System.out.println(""+valBool+"");
        }
    }

    public static String getTaskItemStringValueTEST(ArrayList<TaskItem> TaskItemsTemp, int index, int valSelector){
        String val;
        if(valSelector==1){
            val=TaskItemsTemp.get(index).title;
            System.out.println(""+val+"");
            return val;
        }else if(valSelector==2){
            val=TaskItemsTemp.get(index).description;
            System.out.println(""+val+"");
            return val;
        }else if(valSelector==3){
            val=TaskItemsTemp.get(index).dueDate;
            System.out.println(""+val+"");
            return val;
        }else{
            boolean valBool=TaskItemsTemp.get(index).completed;
            System.out.println(""+valBool+"");
            if(valBool==true){
                return "True";
            }else{
                return "False";
            }
        }
    }

    public static void removeTaskItemTEST(ArrayList<TaskItem> TaskItemsTemp, int index){
        TaskItemsTemp.remove(index);
    }
}
