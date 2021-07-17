package util;

import db.Storage;
import model.Group;
import model.Item;
import model.Resolution;

import java.io.BufferedReader;
import java.io.IOException;

public final class UserInputUtil {
    public static void createGroup(BufferedReader bf) throws IOException {
        while (true) {
            System.out.println("Please Enter name of group");
            String title = bf.readLine();
            if (title.equals("exit")) break;
            UserInputUtil.createSubgroup(title, bf);

        }
    }

    public static void createSubgroup(String title, BufferedReader bf) throws IOException {

        while (true) {
            System.out.println("Please Enter" +
                    "\n 1. ID of parent" +
                    "\n 2. Enter to create group as root level group" +
                    "\n 3. Continue to fill items in group");

            String command = bf.readLine();
            if (command.equals("exit")) break;
            if (command.equals("enter")) {
                Storage.addGroup(Group.buildNewGroup(title));
                break;
            } else if (command.equals("continue")) {
                Storage.addGroup(Group.buildNewGroup(title));
                createItem(bf);
                break;
            } else {
                try {
                    int parentID = Integer.parseInt(command);
                    Group parentGroup = Storage.getGroupById(parentID);
                    if (parentGroup == null) System.out.println("Wrong Id");
                    else {
                        Group group = Group.buildNewGroup(title);
                        Storage.addGroup(group);
                        parentGroup.addGroup(group);


                    }
                } catch (Exception e) {
                    System.out.println("Something went wrong...");
                    break;
                }
            }
        }


    }

    public static void createItem(BufferedReader bf) throws IOException {
        while (true) {
            try {
                System.out.println("Please type title of item");
                String title = bf.readLine();
                if (title.equals("exit")) break;
//                System.out.println("Please type price of item");
//                int price = Integer.parseInt(bf.readLine());
                System.out.println("please enter type of item\n" +
                        "1. Stock" +
                        "\n2. Generative");
                String type = bf.readLine();
                System.out.println("please enter type of Resolution\n" +
                        "1. HD" +
                        "\n2. FHD"
                        + "\n3.FourK  ");
                String resolution = bf.readLine();
                Resolution resolution1 = Resolution.valueOf(resolution);

                System.out.println("Please type currency of item");
                String currency = bf.readLine();
                System.out.println("Please type id of group");
                int groupId = Integer.parseInt(bf.readLine());
                Group parent = Storage.getGroupById(groupId);
                if (parent != null) {
                    Storage.addItem(type, title, resolution1, currency);
                    parent.addItem(Storage.getLastItem());
                }

            } catch (Exception e) {
                System.out.println("Something went wrong.. we are sorry");
                break;
            }


        }

    }

    public static void createBasket(BufferedReader bf) throws IOException {
        System.out.println("Please enter ID of items you want to add in basket or type exit");
        System.out.println("available items: " + Storage.getItemList());
        String command = bf.readLine();
        while (!command.equals("exit")) {
            try {
                int id = Integer.parseInt(command);
                Item item = Storage.getItemById(id);
                Storage.getBASKET().add(item);
                System.out.println("Item is added succesfully... type next ID or type exit");
                command = bf.readLine();
            } catch (Exception e) {
                System.out.println("Something went wrong...we are sorry");
            }
        }
        printPrice();
    }

    public static void printPrice() {
        System.out.println("Items in your basket: " + Storage.getBASKET());
        int summ = 0;
        for (Item item : Storage.getBASKET()) {
            summ += item.getPrice();
        }
        System.out.println("Summ of your Basket:" + summ);
    }

    private UserInputUtil() {
    }
}
