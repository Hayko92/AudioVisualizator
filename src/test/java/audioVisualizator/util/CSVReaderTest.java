package audioVisualizator.util;

import audioVisualizator.exceptions.AppRuntimeException;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class CSVReaderTest {
    @Test
    public void getDataFromFIleTest() {
        File file = new File("Wrong path");
        assertThrows(AppRuntimeException.class, () -> CSVReader.getDataFromFIle(file));
    }
}
