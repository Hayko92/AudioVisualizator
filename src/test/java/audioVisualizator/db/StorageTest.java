package audioVisualizator.db;


import audioVisualizator.model.Configuration;
import audioVisualizator.model.Group;
import audioVisualizator.model.Item;
import audioVisualizator.model.Resolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.Optional;




import static org.junit.jupiter.api.Assertions.*;

public class StorageTest {
    @BeforeEach
    public void clearData() {
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
        Optional<Group> received = Storage.findGroupById(group.getId());
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
        Optional<Item> received = Storage.findItemById(item.getId());
        assertTrue(received.isPresent());
        assertEquals(item, received.get());
    }

    @Test
    public void getGroupByIdTest() {
        Group group = new Group("Test");
        Storage.addGroup(group);
        Optional<Group> received = Storage.findGroupById(group.getId());
        assertTrue(received.isPresent());
        assertEquals(group.getId(), received.get().getId());
    }

    @Test
    public void getItemByIdTest() {
        Item item = new Item("Test", 1, "URL", new Configuration(Resolution.FHD), "USD");
        Storage.addItem(item);
        Optional<Item> received = Storage.findItemById(item.getId());
        assertTrue(received.isPresent());
        assertEquals(item.getId(), received.get().getId());
    }
}
