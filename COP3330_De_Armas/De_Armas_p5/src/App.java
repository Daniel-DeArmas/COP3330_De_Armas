import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        ArrayList<TaskList> TaskLists = new ArrayList<TaskList>();
        ArrayList<ContactList> ContactLists = new ArrayList<ContactList>();

        int x = 0;
        while (x != 3) {
            printAppSelect();
            x = getInt();

            if (x == 1) {
                //ArrayList<TaskList> TaskLists = new ArrayList<TaskList>();
                TaskApp.main(TaskLists);
            } else if (x == 2) {
                //ArrayList<ContactList> ContactLists = new ArrayList<ContactList>();
                ContactApp.main(ContactLists);
            } else if (x == 3) {
                System.out.println("END");
            } else {
                System.out.println("Value entered is invalid. Please Try Again.");
            }
        }
    }

    public static int getInt() {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        return x;
    }

    public static void printAppSelect() {
        System.out.println("Select Your Application");
        System.out.println("---------");
        System.out.println("");
        System.out.println("1) task list");
        System.out.println("2) contact list");
        System.out.println("3) quit");
        System.out.println("");
    }
}