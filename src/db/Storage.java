package db;

import model.Group;
import model.Item;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final List<Group> GROUP_LIST = new ArrayList<>();
    private static final List<Item> ITEM_LIST = new ArrayList<>();

    public static void addGroup(Group group) {
        GROUP_LIST.add(group);
    }

    public static void addItem(String title, int price, String currency) {
        ITEM_LIST.add(new Item(ITEM_LIST.size(), title, price, currency));
    }

    public static Group getGroupById(int id) {
        if (id >= 0 && id < GROUP_LIST.size()) return GROUP_LIST.get(id);
        else return null;
    }

    public static Item getLastItem() {
        if (GROUP_LIST.size() > 0) return ITEM_LIST.get(GROUP_LIST.size() - 1);
        else return null;
    }

    public static void printContent() {
        for (Group group : GROUP_LIST) {
            group.printContent();
        }
    }

    public static List<Group> getGroupList() {
        return GROUP_LIST;
    }

    public static List<Item> getItemList() {
        return ITEM_LIST;
    }
}

