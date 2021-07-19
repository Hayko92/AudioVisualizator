package model;

import db.Storage;

import java.util.*;

public class Group {
    private final int id;
    private final String title;
    private Group parent;
    private final List<Item> items;
    private final List<Group> groups;

    public Group(int id, String title) {
        this.id = id;
        this.title = title;
        this.items = new ArrayList<>();
        this.groups = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void addItem(Item item) {
        this.items.add(item);
        item.setParent(this);
    }

    public void addGroup(Group group) {
        this.groups.add(group);
        group.setParent(this);

    }

    public void setParent(Group parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "model.Group{" +
                "id=" + id +
                ", title='" + title + "}";
    }

    public static Group buildNewGroup(String title) {
        return new Group(Storage.getGroupList().size(), title);
    }

    public void printContent() {
        System.out.println("parent of group " + getTitle() + ": " + parent);
        System.out.println("Items in group " + getTitle() + ": " + items);
        System.out.println("subgroups of group " + getTitle() + ": " + groups);
    }
}
