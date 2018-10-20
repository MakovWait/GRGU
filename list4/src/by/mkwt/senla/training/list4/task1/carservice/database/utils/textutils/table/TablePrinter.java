package by.mkwt.senla.training.list4.task1.carservice.database.utils.textutils.table;

import by.mkwt.senla.training.list4.task1.carservice.database.table.Table;

public class TablePrinter {

    public static void print(Table table) {
        System.out.println(table.getTableName());

        for (String fieldName : table.getFieldNames()) {
            System.out.print(TableStringConverter.BORDER + fieldName + TableStringConverter.BORDER);
        }

        System.out.println();
        System.out.print(TableStringConverter.convertToString(table));
    }

}
