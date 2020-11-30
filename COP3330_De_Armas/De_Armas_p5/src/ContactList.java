import java.util.ArrayList;

public class ContactList {
    ArrayList<ContactItem> ContactItems = new ArrayList<>();
    String name;

    public ContactList(String listName, ArrayList<ContactItem> ContactItemsTemp) {
        this.name = listName;
        this.ContactItems = ContactItemsTemp;
    }
}
