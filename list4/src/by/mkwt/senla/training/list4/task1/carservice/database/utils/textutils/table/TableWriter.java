package by.mkwt.senla.training.list4.task1.carservice.database.utils.textutils.table;

import by.mkwt.senla.training.list4.task1.carservice.database.table.Table;
import by.mkwt.senla.training.list4.task1.carservice.database.utils.textutils.table.TableStringConverter;
import com.senla.training.TextFileWorker;

public class TableWriter {
    private static TextFileWorker fileWorker;

    public static void writeToFile(String file_path, Table table) {
        fileWorker = new TextFileWorker(file_path);

        fileWorker.writeToFile(TableStringConverter.convertToString(table).split("\n"));
    }
}
