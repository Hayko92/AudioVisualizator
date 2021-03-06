


import audioVisualizator.db.Storage;
import audioVisualizator.exceptions.AppRuntimeException;
import audioVisualizator.model.Group;
import audioVisualizator.model.Item;
import audioVisualizator.util.CSVReader;
import audioVisualizator.util.UserInputUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;


public class Main {
    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            UserInputUtil.createGroup(bf);
            UserInputUtil.createBasket(bf);

        } catch (IOException e) {
            throw new AppRuntimeException("You have entered wrong input");
        }
        File file = new File("src/main/resources/item.csv");

        List<String> lines = CSVReader.getDataFromFIle(file);

        for (String line : lines) {
            String[] itemFields = line.split(",");
            int id = Integer.parseInt(itemFields[0]);
            int basePrice = Integer.parseInt(itemFields[1]);
            String name = itemFields[2];
            String imageURl = itemFields[3];

            int parentId = Integer.parseInt(itemFields[4]);
            Optional<Group> parent = Storage.getGroupById(parentId);

            Item item = new Item( name, basePrice, imageURl);
            parent.ifPresent(item::setParent);

            Storage.addItem(item);
        }
        for (Item item : Storage.getItemList()) {
            System.out.println(item);
        }

    }
}