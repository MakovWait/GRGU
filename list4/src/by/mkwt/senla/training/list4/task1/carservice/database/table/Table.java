package by.mkwt.senla.training.list4.task1.carservice.database.table;

import by.mkwt.senla.training.list4.task1.carservice.database.table.structure.row.Record;

public class Table {
    private Record[] records;
    private String tableName;
    private String[] fieldNames;

    public Table(String tableName, String[] fieldNames, Record[] records) {
        this.tableName = tableName;
        this.fieldNames = fieldNames;
        this.records = records;
    }

    public String getTableName() {
        return tableName;
    }

    public String[] getFieldNames() {
        return fieldNames;
    }

    public Record getRecordByIndex(int index) {
        return records[index];
    }

    public Record[] getAllRecords() {
        return records;
    }

    public int getNumOfField() {
        return fieldNames.length;
    }

    public int getNumOfRows() {
        return records.length;
    }
}
