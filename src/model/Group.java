package model;

import java.util.*;

public class Group {
    private int id;
    private String title;
    private Group parent;
    private List<Item> items;
    private List<Group> groups;

    public Group(int id, String title ) {
        this.id = id;
        this.title = title;
        this.items = new ArrayList<>();
        this.groups = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void addGroups( Group group) {
        this.groups.add(group);
    }

    public Group getParent() {
        return parent;
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
    public void printContent() {
        System.out.println("Items in group "+ getTitle()+": "+items);
        System.out.println("Subgroups in group "+getTitle()+": "+ groups);
        System.out.println("parent of group "+getTitle()+": "+ parent);


    }
}
