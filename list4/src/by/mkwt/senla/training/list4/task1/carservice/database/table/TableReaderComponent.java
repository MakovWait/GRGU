package by.mkwt.senla.training.list4.task1.carservice.database.table;

import com.senla.training.TextFileWorker;

public class TableReaderComponent {

    private TextFileWorker tableReader;
    private TextFileWorker descriptionReader;

    public TableReaderComponent(String pathToTable, String pathToTableDescription) {
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
