package by.mkwt.senla.training.list4.task1.carservice.table.structure;

import by.mkwt.senla.training.list4.task1.carservice.table.structure.record.Record;

import java.util.List;

public class Table {

    private String tableName;
    private List<String> fieldNames;
    private List<Record> records;

    public Table(String tableName, List<String> fieldNames, List<Record> records) {
        this.tableName = tableName;
        this.fieldNames = fieldNames;
        this.records = records;
    }

    public String getTableName() {
        return tableName;
    }

    public List<String> getFieldNames() {
        return fieldNames;
    }

    public Record getRecordByIndex(int index) {

        return records.get(index);
    }

    public List<Record> getAllRecords() {
        return records;
    }

    public int getNumOfField() {
        return fieldNames.size();
    }

    public int getNumOfRecords() {
        return records.size();
    }
}
