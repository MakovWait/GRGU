package by.mkwt.senla.training.list4.task1.carservice.table.utils.textutils.record;

import java.util.ArrayList;
import java.util.Arrays;

public class RecordParser {
    private static final String DELIMITER = "\\|";

    public static ArrayList<String> getValues(String line) {
        ArrayList<String> result = new ArrayList<>(Arrays.asList(line.split(DELIMITER)));
        return result;
    }
}
