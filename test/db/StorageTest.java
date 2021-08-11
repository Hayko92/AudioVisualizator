package db;

import model.Configuration;
import model.Group;
import model.Item;
import model.Resolution;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class StorageTest {
@BeforeEach
public   void clearData() {
    Storage.getGroupList().clear();
    Storage.getItemList().clear();
}

    @Test
    public void addGroupTest() {

        Group group = new Group("Test");
        int oldSize = Storage.getGroupList().size();
        Storage.addGroup(group);
        int newSize = Storage.getGroupList().size();
        assertEquals(1, newSize - oldSize);
        Optional<Group> received = Storage.findGroupById(1);
        assertTrue(received.isPresent());
        assertEquals(group, received.get());
    }

    @Test
    public void addItemTest() {
        Item item = new Item("Test", 100, "URL", new Configuration(Resolution.FHD), "USD");
        int oldSize = Storage.getItemList().size();
        Storage.addItem(item);
        int newSize = Storage.getItemList().size();
        assertEquals(1, newSize - oldSize);
        Optional<Item> received = Storage.findItemById(1);
        assertTrue(received.isPresent());
        assertEquals(item, received.get());
    }

    @Test
    public void getGroupByIdTest() {
        Group group = new Group("Test");
        Storage.addGroup(group);
        Optional<Group> received = Storage.findGroupById(1);
        assertEquals(1, received.get().getId());
    }
    @Test
    public void getItemByIdTest() {
        Item item = new Item("Test",1,"URL",new Configuration(Resolution.FHD),"USD");
        Storage.addItem(item);
        Optional<Item> received = Storage.findItemById(1);
        assertEquals(1, received.get().getId());
    }
}