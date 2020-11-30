import java.util.ArrayList;
import java.util.Scanner;

public class ContactApp {

    public static void main(ArrayList<ContactList> ContactLists) {
        //ArrayList<ContactList> ContactLists = new ArrayList<ContactList>();

        int x = 0;
        while(x!=3) {
            printContactMainMenu();
            x = getInt();

            if (x == 1) {
                createList(ContactLists);
            } else if (x == 2) {
                loadList(ContactLists);
            } else if(x==3){
                System.out.println("END");
            }else{
                System.out.println("Value entered is invalid. Please Try Again.");
            }
        }
    }

    public static int getInt() {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        return x;
    }

    public static String getString(){
        Scanner scan = new Scanner(System.in);
        String x = scan.next();
        return x;
    }

    public static void printContactMainMenu(){
        System.out.println("Main Menu");
        System.out.println("---------");
        System.out.println("");
        System.out.println("1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit");
        System.out.println("");
    }

    public static void createList(ArrayList<ContactList> ContactLists){
        ArrayList<ContactItem> ContactItemsTemp = new ArrayList<ContactItem>();

        int x=0;

        while(x!=6){
            printContactListOpMenu();
            x = getInt();
            if (x == 1) {
                printContactItems(ContactItemsTemp);
            } else if (x == 2) {
                listOpAddContactItem(ContactItemsTemp);
            } else if (x == 3) {
                printContactItems(ContactItemsTemp);
                listOpEditContactItem(ContactItemsTemp);
            } else if (x == 4) {
                printContactItems(ContactItemsTemp);
                listOpRemoveContactItem(ContactItemsTemp);
            } else if (x == 5) {
                listOpSaveContactList(ContactItemsTemp, ContactLists);
            } else if (x == 6) {
                //back to main menu
            } else {
                System.out.println("Value entered is invalid. Please Try Again.");
            }
        }
    }

    public static void loadList(ArrayList<ContactList> ContactLists){
        ArrayList<ContactItem> ContactItemsTemp = null;
        System.out.println("Current Tasks");
        System.out.println("-------------");
        System.out.println("");
        for(int i = 0; i < ContactLists.size(); i++) {
            System.out.println(i + ") " + ContactLists.get(i).name);
        }
        System.out.println("");
        System.out.println("Enter the file name to load: ");
        String z = getString();

        int x=0;
        int y=-1;
        for(int i = 0; i < ContactLists.size(); i++) {
            if (ContactLists.get(i).name.equals(z)) {
                y = i;
            }
        }

        if(y==-1){
            x=8;
        }

        try{
            ContactItemsTemp = ContactLists.get(y).ContactItems;
        }catch (IndexOutOfBoundsException e){
            System.out.println("Warning: TasksLists is empty or File dosen't exist");
            System.out.println("");
        }

        while(x!=6){
            printContactListOpMenu();
            x = getInt();
            if (x == 1) {
                printContactItems(ContactItemsTemp);
            } else if (x == 2) {
                listOpAddContactItem(ContactItemsTemp);
            } else if (x == 3) {
                printContactItems(ContactItemsTemp);
                listOpEditContactItem(ContactItemsTemp);
            } else if (x == 4) {
                printContactItems(ContactItemsTemp);
                listOpRemoveContactItem(ContactItemsTemp);
            } else if (x == 5) {
                z = ContactLists.get(y).name;
                ContactList List = new ContactList(z, ContactItemsTemp);
                ContactLists.set(y, List);
                System.out.println("task list has been saved");
            } else if (x == 6) {
                //back to main menu
            } else {
                System.out.println("Value entered is invalid. Please Try Again.");
            }
        }
    }

    public static void printContactItems(ArrayList<ContactItem> ContactItemsTemp){
        System.out.println("Current Contacts");
        System.out.println("-------------");
        System.out.println("");
        for(int i = 0; i < ContactItemsTemp.size(); i++) {
            System.out.println(i+") Name: "+ContactItemsTemp.get(i).firstName+" "+ContactItemsTemp.get(i).lastName+
                    "\nPhone: "+ContactItemsTemp.get(i).phoneNumber+"\nEmail: "+ContactItemsTemp.get(i).emailAddress);
        }
        System.out.println("");
    }

    public static void printContactListOpMenu(){
        System.out.println("List Operation Menu");
        System.out.println("---------");
        System.out.println("");
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) save the current list");
        System.out.println("6) quit to the main menu");
        System.out.println("");
    }

    public static void listOpAddContactItem(ArrayList<ContactItem> ContactItemsTemp) {
        System.out.print("First Name: ");
        String firstName = getString();
        System.out.print("Last Name: ");
        String lastName = getString();
        System.out.print("Phone Number (xxx-xxx-xxxx): ");
        String phoneNumber = getString();
        System.out.print("Email Address (x@y.z): ");
        String emailAddress = getString();
        System.out.println("");

        try {
            ContactItem Contact = new ContactItem(firstName, lastName, phoneNumber, emailAddress);
            ContactItemsTemp.add(Contact);
        }catch(IllegalArgumentException e){
            System.out.println("WARNING: name must be at least 1 character long and/or due date was input wrong; task not created");
        }
    }

    public static void listOpEditContactItem(ArrayList<ContactItem> ContactItemsTemp){
        System.out.println("Which Contact will you edit?");
        int y = getInt();
        System.out.print("Enter a new first name for Contact "+y+": ");
        String firstName = getString();
        System.out.print("Enter a new last name for Contact "+y+": ");
        String lastName = getString();
        System.out.print("Enter a new phone number (xxx-xxx-xxxx) for Contact "+y+": ");
        String phoneNumber = getString();
        System.out.print("Enter a new email address (x@y.z) for Contact "+y+": ");
        String emailAddress = getString();
        System.out.println("");
        try {
            ContactItem Contact = new ContactItem(firstName, lastName, phoneNumber, emailAddress);
            ContactItemsTemp.set(y,Contact);
        }catch(IllegalArgumentException e){
            System.out.println("WARNING: name must be at least 1 character long and/or due date was input wrong; edit cancelled");
        }catch (IndexOutOfBoundsException e){
            System.out.println("Warning: invalid task selected, edit cancelled");
        }
    }

    public static void listOpRemoveContactItem(ArrayList<ContactItem> ContactItemsTemp){
        System.out.println("Which Contact will you remove?");
        int y = getInt();
        try{
            ContactItemsTemp.remove(y);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Warning: no Contact was selected, nothing was removed");
        }
    }

    public static void listOpSaveContactList(ArrayList<ContactItem> ContactItemsTemp, ArrayList<ContactList> ContactLists){
        System.out.println("Enter the filename to save as: ");
        String z = getString();
        ContactList List = new ContactList(z, ContactItemsTemp);
        ContactLists.add(List);
        System.out.println("Contact list has been saved");
    }
}
