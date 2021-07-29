import db.Storage;
import model.Group;
import util.UserInputUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        UserInputUtil.createGroup(bf);
        for(Group group: Storage.getGroupList()) {
            group.print(0);
        }
        UserInputUtil.createBasket(bf);
        Storage.findItemById(0).print();
    }
}