package by.mkwt.senla.training.list4.task1.carService.database.utils;

public class RecordParser {
    private static final String DELIMITER = ";";

    public static String[] getValues(String line) {
        return line.split(DELIMITER);
    }
}
