import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ContactItemList {
    @Test
    public void creationFailsWithAllBlankValues(){
        assertThrows(IllegalArgumentException.class, ()  -> new ContactItem("","","",""));
    }

    @Test
    public void creationSucceedsWithBlankEmail(){
        ContactItem ContactItems = new ContactItem("first","last","123-456-7890","");
    }

    @Test
    public void creationSucceedsWithBlankFirstName(){
        ContactItem ContactItems = new ContactItem("","last","123-456-7890","x@y.z");    }

    @Test
    public void creationSucceedsWithBlankLastName(){
        ContactItem ContactItems = new ContactItem("first","","123-456-7890","x@y.z");    }

    @Test
    public void creationSucceedsWithBlankPhone(){
        ContactItem ContactItems = new ContactItem("first","last","","x@y.z");    }

    @Test
    public void creationSucceedsWithNonBlankValues(){
        ContactItem ContactItems = new ContactItem("first","last","123-456-7890","x@y.z");
    }

    @Test
    public void editingFailsWithAllBlankValues(){
        ArrayList<ContactItem> ContactItemsTemp = new ArrayList<ContactItem>();

        ContactItem ContactItems = new ContactItem("first","last","123-456-7890","x@y.z");
        ContactItemsTemp.add(ContactItems);

        assertThrows(IllegalArgumentException.class, () -> new ContactItem("","","",""));
        ContactItemsTemp.set(0,ContactItems);
    }

    @Test
    public void editingSucceedsWithBlankEmail(){
        ArrayList<ContactItem> ContactItemsTemp = new ArrayList<ContactItem>();

        ContactItem ContactItems = new ContactItem("first","last","123-456-7890","x@y.z");
        ContactItemsTemp.add(ContactItems);

        ContactItems = new ContactItem("first","last","123-456-7890","");
        ContactItemsTemp.set(0,ContactItems);
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ArrayList<ContactItem> ContactItemsTemp = new ArrayList<ContactItem>();

        ContactItem ContactItems = new ContactItem("first","last","123-456-7890","x@y.z");
        ContactItemsTemp.add(ContactItems);

        ContactItems = new ContactItem("","last","123-456-7890","");
        ContactItemsTemp.set(0,ContactItems);
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ArrayList<ContactItem> ContactItemsTemp = new ArrayList<ContactItem>();

        ContactItem ContactItems = new ContactItem("first","last","123-456-7890","x@y.z");
        ContactItemsTemp.add(ContactItems);

        ContactItems = new ContactItem("first","","123-456-7890","");
        ContactItemsTemp.set(0,ContactItems);
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ArrayList<ContactItem> ContactItemsTemp = new ArrayList<ContactItem>();

        ContactItem ContactItems = new ContactItem("first","last","123-456-7890","x@y.z");
        ContactItemsTemp.add(ContactItems);

        ContactItems = new ContactItem("first","last","","");
        ContactItemsTemp.set(0,ContactItems);
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        ArrayList<ContactItem> ContactItemsTemp = new ArrayList<ContactItem>();

        ContactItem ContactItems = new ContactItem("first","last","123-456-7890","x@y.z");
        ContactItemsTemp.add(ContactItems);

        ContactItems = new ContactItem("first1","last1","123-455-7890","a@b.c");
        ContactItemsTemp.set(0,ContactItems);
    }

    @Test
    public void testToString(){
        ContactItem ContactItems = new ContactItem("first","last","123-456-7890","x@y.z");
        String Contact = ContactItems.toString();
    }
}
