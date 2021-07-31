package db;

import model.*;

import java.util.*;
import java.util.stream.Collectors;


public final class Storage {
    private static final List<Group> GROUP_LIST = new ArrayList<>();
    private static final List<Item> ITEM_LIST = new ArrayList<>();

    static {
        GROUP_LIST.add(new Group(0, "First"));
        GROUP_LIST.add(new Group(1, "Sec"));
        GROUP_LIST.add(new Group(2, "Third"));
        GROUP_LIST.add(new Group(3, "Fourth"));

        ITEM_LIST.add(new Item(100, "First", 10, "URL1", new Configuration(Resolution.FHD), "USD"));
        ITEM_LIST.add(new Item(110, "Sec", 11, "URL2", new Configuration(Resolution.HD), "USD"));
        ITEM_LIST.add(new Item(220, "Third", 19, "URL3", new Configuration(Resolution.FourK), "USD"));
        ITEM_LIST.add(new Item(300, "Fourth", 15, "URL4", new Configuration(Resolution.FHD), "USD"));
        ITEM_LIST.add(new Item(400, "Fourth", 15, "URL5", new Configuration(Resolution.FHD), "USD"));
        ITEM_LIST.add(new Item(500, "Fourth", 15, "URL6", new Configuration(Resolution.FHD), "USD"));
    }

    private Storage() {
    }

    public static void addGroup(Group group) {
        GROUP_LIST.add(group);
    }

    public static void addItem(String type, String title, int price, String image_URL, Configuration configuration, double complexity, String currency) throws Exception {
        if (type.equalsIgnoreCase("Stock")) {
            ITEM_LIST.add(new Stock(ITEM_LIST.size(), title, price, image_URL, configuration, currency));
        } else if (type.equalsIgnoreCase("Generative"))
            ITEM_LIST.add(new Generative(ITEM_LIST.size(), title, price, image_URL, configuration, complexity, currency));
        else throw new Exception("Wrong type");
    }

    public static void addItem(Item item) {
        ITEM_LIST.add(item);
    }

    public static Optional<Group> getGroupById(int id) {
        if (id >= 0 && id < GROUP_LIST.size()) return findGroupById(id);
        else return Optional.empty();
    }

    public static Optional<Item> getItemById(int id) {
        if (id >= 0 && id < ITEM_LIST.size()) return findItemById(id);
        else return Optional.empty();
    }

    public static Optional<Item> getLastItem() {
        if (GROUP_LIST.size() > 0) return getItemById(ITEM_LIST.size() - 1);
        else return null;
    }


    public static List<Group> getGroupList() {
        return GROUP_LIST;
    }

    public static List<Item> getItemList() {
        return ITEM_LIST;
    }

    public static Optional<Item> findItemById(int id) {
        return getItemList()
                .stream()
                .filter(el -> el.getId() == id)
                .findAny();
    }

    public static Optional<Item> findItemByName(String name) {
        return getItemList()
                .stream()
                .filter(el -> el.getTitle().equals(name))
                .findAny();
    }

    public static Optional<Group> findGroupById(int id) {
        return getGroupList()
                .stream()
                .filter(el -> el.getId() == id)
                .findAny();


    }

    public static Group findGroupByName(String name) {
        return getGroupList()
                .stream()
                .filter(el -> el.getTitle().equals(name))
                .findAny().orElse(null);

    }

    public static List<Group> findSubGroupsByParent(Group parent) {
        return getGroupList()
                .stream()
                .filter(el -> el.getParent().equals(parent))
                .collect(Collectors.toList());
    }

    public static List<Item> findHighestPricedItems() {
        int highestPrice = getItemList()
                .stream()
                .max(Comparator.comparingInt(Item::getPrice))
                .get().getPrice();

        return getItemList()
                .stream()
                .filter(el -> el.getPrice() == highestPrice)
                .collect(Collectors.toList());
    }

    public static List<Item> findAllItemsByPrice(int price) {
        return getItemList()
                .stream().filter(el -> el.getPrice() == price)
                .collect(Collectors.toList());
    }

    public static List<Group> findSubGroupsByParentId(int parentId) {
        return getGroupList()
                .stream()
                .filter(el -> el.getId() == parentId)
                .map(Group::getGroups)
                .findAny()
                .orElse(null);
    }

}

