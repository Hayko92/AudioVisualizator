package db;

import model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class Storage {
    private static final List<Group> GROUP_LIST = new ArrayList<>();
    private static final List<Item> ITEM_LIST = new ArrayList<>();

    public static void addGroup(Group group) {
        GROUP_LIST.add(group);
    }

    public static void addItem(String type, String title, int price, Configuration configuration, double complexity, String currency) throws Exception {
        if (type.equalsIgnoreCase("Stock")) {
            ITEM_LIST.add(new Stock(ITEM_LIST.size(), title, price, configuration, currency));
        } else if (type.equalsIgnoreCase("Generative"))
            ITEM_LIST.add(new Generative(ITEM_LIST.size(), title, price, configuration, complexity, currency));
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


    public static List<Group> getGroupList() {
        return GROUP_LIST;
    }

    public static List<Item> getItemList() {
        return ITEM_LIST;
    }

    public static Item findItemById(int id) {
        return getItemList().stream().filter(el -> el.getId() == id).findAny().get();
    }

    public static Item findItemByName(String name) {
        return getItemList().stream().filter(el -> el.getTitle().equals(name)).findAny().get();
    }

    public static Group findGroupById(int id) {
        return getGroupList().stream().filter(el -> el.getId() == id).findAny().get();
    }

    public static Group findGroupByName(String name) {
        return getGroupList().stream().filter(el -> el.getTitle().equals(name)).findAny().get();
    }

    public static List<Group> findSubGroupsByParent(Group parent) {
        return getGroupList().stream().filter(el -> el.getParent().equals(parent)).collect(Collectors.toList());
    }

    public static List<Item> findHighestPricedItems() {
        int highestPrice = getItemList().stream().max(Comparator.comparingInt(Item::getPrice)).get().getPrice();
        return getItemList().stream().filter(el -> el.getPrice() == highestPrice).collect(Collectors.toList());
    }

    public static List<Item> findAllItemsByPrice(int price) {
        return getItemList().stream().filter(el -> el.getPrice() == price).collect(Collectors.toList());
    }

    private Storage() {
    }
}

