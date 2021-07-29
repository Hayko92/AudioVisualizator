import db.Storage;
import model.Group;
import model.Item;
import util.UserInputUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        UserInputUtil.createGroup(bf);
        for(Group group: Storage.getGroupList()) {
            group.print(0);
        }
        UserInputUtil.createBasket(bf);
        Optional<Item> item = Storage.findItemById(0);
        item.ifPresent(System.out::println);
        System.out.println(Storage.findAllItemsByPrice(15));
        System.out.println(Storage.findGroupById(0));
        System.out.println(Storage.findGroupByName("First"));
        System.out.println(Storage.findGroupByName("sdsds"));
        System.out.println(Storage.findHighestPricedItems());
        System.out.println(Storage.findSubGroupsByParentId(0));
    }
}