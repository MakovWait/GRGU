package by.mkwt.senla.training.list4.task1.carservice.database.utils;

import by.mkwt.senla.training.list4.task1.carservice.database.table.Table;

public class TablePrinter {

    private final static String BORDER = "|";

    public static void print(Table table) {
        System.out.println(table.getTableName());

        for (String fieldName : table.getFieldNames()) {
            System.out.print(BORDER + fieldName + BORDER);
        }

        System.out.println();

        for (int i = 0; i < table.getNumOfRows(); i++) {
            for (int j = 0; j < table.getNumOfField(); j++) {
                System.out.print(BORDER + table.getRecordByIndex(i).getFieldByIndex(j).getValue() + BORDER);
            }
            System.out.println();
        }
    }
}
