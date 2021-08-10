package db;

import model.Configuration;
import model.Group;
import model.Item;
import model.Resolution;
import org.junit.Test;


import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class StorageTest {
    @Test
    public void addGroupTestBySize(){
        Group group = new Group(100,"Test");
        int oldSize = Storage.getGroupList().size();
        Storage.addGroup(group);
        int newSize = Storage.getGroupList().size();
        assertEquals(1, newSize - oldSize);
        Optional<Group> received = Storage.findGroupById(100);
        assertTrue(received.isPresent());
        assertEquals(group, received.get());
    }

    @Test
    public void addItemTest() {
        Item item = new Item(1000,"Test",100,"URL", new Configuration(Resolution.FHD),"USD");
       int oldSize = Storage.getItemList().size();
        Storage.addItem(item);
        int newSize = Storage.getItemList().size();
        assertEquals(1, newSize-oldSize);
        Optional<Item> received = Storage.findItemById(1000);
        assertTrue(received.isPresent());
        assertEquals(item,received.get());
    }
    @Test
    public void getGroupByIdTest() {
        Group group = new Group(100,"Test");
        Storage.addGroup(group);
        Optional<Group>  received = Storage.findGroupById(100);
        assertEquals(100,received.get().getId());
    }
}
