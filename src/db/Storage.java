package db;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final List<Group> GROUP_LIST = new ArrayList<>();
    private static final List<Item> ITEM_LIST = new ArrayList<>();

    public static void addGroup(Group group) {
        GROUP_LIST.add(group);
    }

    public static void addItem(String type, String title, int price, Configuration configuration, String currency) throws Exception {
        if (type.equalsIgnoreCase("Stock")) {

            ITEM_LIST.add(new Stock(ITEM_LIST.size(), title, price, configuration, currency));
        } else if (type.equalsIgnoreCase("Generative"))
            ITEM_LIST.add(new Generative(ITEM_LIST.size(), title, price, configuration, currency));
        else throw new Exception("Wrong type");
    }

    public static Group getGroupById(int id) {
        if (id >= 0 && id < GROUP_LIST.size()) return GROUP_LIST.get(id);
        else return null;
    }

    public static Item getItemById(int id) {
        if (id >= 0 && id < ITEM_LIST.size()) return ITEM_LIST.get(id);
        else return null;
    }

    public static Item getLastItem() {
        if (GROUP_LIST.size() > 0) return ITEM_LIST.get(ITEM_LIST.size() - 1);
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

