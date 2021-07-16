import model.Group;
import model.Item;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static List<Group> groupList = new ArrayList<>();
    private static List<Item> itemList = new ArrayList<>();

    public static void addGroup(String title) {
       groupList.add(new Group(groupList.size(), title));
    }
    public static void addItem(String title, int price, String currency) {
         itemList.add(new Item(itemList.size(),title,price,currency));
    }

    public static Group getLastGroup() {
        if(groupList.size()>0) return groupList.get(groupList.size()-1);
        else return null;
    }
    public static Group getGroupById(int id) {
        if(id>=0&&id<groupList.size()) return groupList.get(id);
        else return null;
    }
    public static Item getLastItem() {
        if(groupList.size()>0) return itemList.get(groupList.size()-1);
        else return null;
    }
    public static void printContent() {
        for(Group group: groupList) {
         group.printContent();
        }
    }
}

