import model.Group;
import model.Item;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Please Enter name of group");
            String title = bf.readLine();
            if(title.equals("exit")) break;
             UserInputUtil.createGroup(title,bf);

       }
        Storage.printContent();
    }
}