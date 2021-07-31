import db.Storage;
import model.Group;
import model.Item;
import util.FileInputUtil;
import util.UserInputUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        UserInputUtil.createGroup(bf);
        UserInputUtil.createBasket(bf);

        File file = new File("src/main/resources/item.csv");
        FileInputUtil.transferDataFromFile(file);
        for(Item item: Storage.getItemList()) {
            System.out.println(item);
        }

    }
}