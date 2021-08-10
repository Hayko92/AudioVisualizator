package db;

import model.Group;
import org.junit.Test;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
public class StorageTest {
    @Test
    public void addGroupTest(){
        Group group = new Group(100,"Test");
        Storage.addGroup(group);
        Optional<Group> received = Storage.findGroupById(100);
        assertNotNull(received.get());
    }
}
