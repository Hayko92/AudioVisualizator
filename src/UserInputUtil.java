import model.Group;
import model.Item;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputUtil {
    public static void createGroup(String title, BufferedReader bf) throws IOException {

        while (true) {
            System.out.println("Please Enter" +
                    "\n 1. ID of parent" +
                    "\n 2. Enter to create group as root level group" +
                    "\n 3. Continue to fill items in group");

            String command = bf.readLine();
            if (command.equals("exit")) break;
            if (command.equals("enter")) {
                Storage.addGroup(title);
                break;
            } else if (command.equals("continue")) {
                Storage.addGroup(title);
                createItem(bf);
                break;
            } else {
                try {
                    int parentID = Integer.parseInt(command);
                    Group parentGroup = Storage.getGroupById(parentID);
                    if (parentGroup == null) System.out.println("Wrong Id");
                    else {
                        Storage.addGroup(title);
                        Storage.getLastGroup().setParent(parentGroup);

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
                System.out.println("Please type price of item");
                int price = Integer.parseInt(bf.readLine());
                System.out.println("Please type currency of item");
                String currency = bf.readLine();
                System.out.println("Please type id of group");
                int groupId = Integer.parseInt(bf.readLine());
                Group parent = Storage.getGroupById(groupId);
                if (parent != null) {
                    Storage.addItem(title, price, currency);
                    parent.addItem(Storage.getLastItem());
                }

            } catch (Exception e) {
                System.out.println("Something went wrong.. we are sorry");
                break;
            }


        }

    }

}
