import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ContactListTest {

    @Test
    public void addingItemsIncreasesSize(){
        ArrayList<ContactItem> ContactItemsTest = new ArrayList<>();
        ContactItem ItemTest = new ContactItem("first","last","123-456-7890","x@y.z");
        ContactItemsTest.add(ItemTest);
        int first = ContactItemsTest.size();

        ItemTest = new ContactItem("first1","last1","123-456-7891","x@y.z");
        ContactItemsTest.add(ItemTest);
        int second = ContactItemsTest.size();

        assertEquals(first+1,second);
    }

    @Test
    public void editingItemsFailsWithAllBlankValues(){
        ArrayList<ContactItem> ContactItemsTest = new ArrayList<ContactItem>();
        ContactItem ContactItems =  new ContactItem("first","last","123-456-7890","x@y.z");
        ContactItemsTest.add(ContactItems);

        assertThrows(IllegalArgumentException.class, () -> new ContactItem("","","",""));
    }

    @Test
    public void editingItemsFailsWithInvalidIndex(){
        ArrayList<ContactItem> ContactItemsTest = new ArrayList<ContactItem>();
        ContactItem ContactItems =  new ContactItem("first","last","123-456-7890","x@y.z");
        ContactItemsTest.add(ContactItems);

        ContactItems =  new ContactItem("first1","last1","123-456-7891","xx@y.z");

        ContactItem finalContactItems = ContactItems;
        assertThrows(IndexOutOfBoundsException.class, () -> ContactItemsTest.set(5, finalContactItems));
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ArrayList<ContactItem> ContactItemsTest = new ArrayList<ContactItem>();
        ContactItem ContactItems =  new ContactItem("first","last","123-456-7890","x@y.z");
        ContactItemsTest.add(ContactItems);
        String firstVal = ContactItemsTest.get(0).firstName;

        ContactItems =  new ContactItem("","last","123-456-7890","x@y.z");
        ContactItemsTest.set(0, ContactItems);
        String secondVal = ContactItemsTest.get(0).firstName;

        assertNotEquals(firstVal, secondVal);
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ArrayList<ContactItem> ContactItemsTest = new ArrayList<ContactItem>();
        ContactItem ContactItems =  new ContactItem("first","last","123-456-7890","x@y.z");
        ContactItemsTest.add(ContactItems);
        String firstVal = ContactItemsTest.get(0).lastName;

        ContactItems =  new ContactItem("first","","123-456-7890","x@y.z");
        ContactItemsTest.set(0, ContactItems);
        String secondVal = ContactItemsTest.get(0).lastName;

        assertNotEquals(firstVal, secondVal);
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ArrayList<ContactItem> ContactItemsTest = new ArrayList<ContactItem>();
        ContactItem ContactItems =  new ContactItem("first","last","123-456-7890","x@y.z");
        ContactItemsTest.add(ContactItems);
        String firstVal = ContactItemsTest.get(0).firstName;

        ContactItems =  new ContactItem("","last","123-456-7890","x@y.z");
        ContactItemsTest.set(0, ContactItems);
        String secondVal = ContactItemsTest.get(0).firstName;

        assertNotEquals(firstVal, secondVal);
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        ArrayList<ContactItem> ContactItemsTest = new ArrayList<ContactItem>();
        ContactItem ContactItems =  new ContactItem("first","last","123-456-7890","x@y.z");
        ContactItemsTest.add(ContactItems);

        ContactItems =  new ContactItem("first1","last1","123-456-7891","xx@y.z");
        ContactItemsTest.set(0, ContactItems);
    }

    @Test
    public void newListIsEmpty(){
        ArrayList<ContactItem> ContactItemsTest = new ArrayList<ContactItem>();
        assertEquals(ContactItemsTest.size(), 0);
    }

    @Test
    public void removingItemsDecreasesSize(){
        ArrayList<ContactItem> ContactItemsTest = new ArrayList<ContactItem>();
        ContactItem ContactItems =  new ContactItem("first","last","123-456-7890","x@y.z");
        ContactItemsTest.add(ContactItems);

        ContactItems =  new ContactItem("first1","last1","123-456-7891","xx@y.z");
        ContactItemsTest.add(ContactItems);

        int first = ContactItemsTest.size();
        ContactItemsTest.remove(1);
        int second = ContactItemsTest.size();

        assertEquals(first, second+1);
    }

    @Test
    public void removingItemsFailsWithInvalidIndex(){
        ArrayList<ContactItem> ContactItemsTest = new ArrayList<ContactItem>();
        ContactItem ContactItems =  new ContactItem("first","last","123-456-7890","x@y.z");
        ContactItemsTest.add(ContactItems);

        assertThrows(IndexOutOfBoundsException.class, () -> ContactItemsTest.remove(5));
    }

    @Test
    public void savedContactListCanBeLoaded(){
        ArrayList<ContactItem> ContactItemsTest = new ArrayList<ContactItem>();
        ArrayList<ContactList> ContactLists = new ArrayList<ContactList>();
        ContactItem ItemTest = new ContactItem("first","last","123-456-7890","x@y.z");
        ContactItemsTest.add(ItemTest);
        ContactList ItemsTest = new ContactList("title",ContactItemsTest);
        ContactLists.add(ItemsTest);
        assertEquals(ContactItemsTest, ContactLists.get(0).ContactItems);
    }
}
