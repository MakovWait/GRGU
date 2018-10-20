package by.mkwt.senla.training.list4.task1.carservice.database.utils.textutils.table;

import com.senla.training.TextFileWorker;

public class TableReader {

    private TextFileWorker tableReader;
    private TextFileWorker descriptionReader;

    public TableReader(String pathToTable, String pathToTableDescription) {
        this.tableReader = new TextFileWorker(pathToTable);
        this.descriptionReader = new TextFileWorker(pathToTableDescription);
    }

    public String getTableName() {
        return descriptionReader.readFromFile()[0];
    }

    public String getTableFieldsNames() {
        return descriptionReader.readFromFile()[1];
    }

    public String getTableFieldsTypes() {
        return descriptionReader.readFromFile()[2];
    }

    public String[] getAllTableRecords() {
        return tableReader.readFromFile();
    }
}
