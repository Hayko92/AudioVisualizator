package util;


import db.Storage;
import model.Group;
import model.Item;

import java.io.*;
import java.util.Optional;

public class FileInputUtil {
    //transfering data from file to database
    public static void transferDataFromFile(File file) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(file));
        while (bf.ready()) {
            String line = bf.readLine();
            Item item = lineParserToItem(line);
            Storage.addItem(item);
        }

    }

    //parsing String line to Item and returning it
    public static Item lineParserToItem(String line) {
        String[] itemFields = line.split(",");
        int id = Integer.parseInt(itemFields[0]);
        int basePrice = Integer.parseInt(itemFields[1]);
        String name = itemFields[2];
        String imageURl = itemFields[3];
        int parentId = Integer.parseInt(itemFields[4]);
        Optional<Group> parent = Storage.getGroupById(parentId);
        Item item = new Item(id, name, basePrice, imageURl);
        parent.ifPresent(item::setParent);
        return item;
    }
}
