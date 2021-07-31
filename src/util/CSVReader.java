package util;

import db.Storage;
import model.Item;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private CSVReader() {
    }

    public static List<String> getDataFromFIle(File file) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(file));
        List<String> lines = new ArrayList<>();
        while (bf.ready()) {
            String line = bf.readLine();
            lines.add(line);
        }
        return lines;
    }
}