package audioVisualizator.util;

import audioVisualizator.exceptions.AppRuntimeException;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class CSVReaderTest {
    @Test
    public void getDataFromFIleTest1() {
        File file = new File("wrong path");
        assertThrows(AppRuntimeException.class, () -> CSVReader.getDataFromFIle(file));
    }

    @Test
    public void getDataFromFIleTest2() {
        File file = new File("C:\\Users\\Hayk\\IdeaProjects\\AudioVisualizator-\\src\\main\\resources\\item.csv");
        String lineFromFile = "1,100,Test1,https://test.test/image/1,1";
        String lineFromReader = CSVReader.getDataFromFIle(file).get(0);
        assertEquals(lineFromFile, lineFromReader);
    }
}
