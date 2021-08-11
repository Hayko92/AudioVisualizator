package audioVisualizator.util;

import audioVisualizator.exceptions.AppRuntimeException;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class CSVReaderTest {
    @Test
    public void testingThrowingException() {
        File file = new File("wrong path");
        assertThrows(AppRuntimeException.class, () -> CSVReader.getDataFromFIle(file));
    }

    @Test
    public void testingCorrectReading() {
        File file = new File(Constants.CSV_FILE_PATH);
        Optional<String> firstLine = CSVReader.getDataFromFIle(file)
                .stream()
                .findFirst();
        assertTrue(firstLine.isPresent());
        assertEquals(Constants.FIRST_LINE_OF_CSV, firstLine.get());
    }
}
