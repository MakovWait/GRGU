package by.mkwt.senla.training.list4.task1.carservice.database.utils.textutils.table;

import by.mkwt.senla.training.list4.task1.carservice.database.table.Table;

public class TableStringConverter {

    public final static String BORDER = "|";

    public static String convertToString(Table table) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < table.getNumOfRecords(); i++) {
            for (int j = 0; j < table.getNumOfField(); j++) {
                output.append(BORDER).append(table.getRecordByIndex(i).getFieldByIndex(j).getValue()).append(BORDER);
            }
            output.append("\n");
        }
        return output.toString();
    }
}
