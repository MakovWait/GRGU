package by.mkwt.senla.training.list4.task1.carservice.table.utils.textutils.table;

import by.mkwt.senla.training.list4.task1.carservice.table.structure.Table;
import by.mkwt.senla.training.list4.task1.carservice.table.utils.builders.TableBuilder;
import com.senla.training.TextFileWorker;

public class TableWriter {
    private static TextFileWorker fileWorker;

    public static void writeToFile(String filePathToTable, Table table) {
        fileWorker = new TextFileWorker(filePathToTable + TableBuilder.VALUES);

        fileWorker.writeToFile(TableStringConverter.convertToString(table).split("\n"));
    }
}
