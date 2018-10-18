package by.mkwt.senla.training.list4.task1.carService.database.table;

import by.mkwt.senla.training.list4.task1.carService.database.table.structure.row.Record;
import by.mkwt.senla.training.list4.task1.carService.database.utils.TableSorter;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Table {
    private String tableName;
    private String[] fieldNames;
    private Record[] records;


    public Table(String tableName, String[] fieldNames, Record[] records) {
        this.tableName = tableName;
        this.fieldNames = fieldNames;
        this.records = records;
    }

    public void orderBy(String fieldName) {
        TableSorter sorter = new TableSorter();
        sorter.setSortedField(fieldName);

        Arrays.sort(records, sorter);
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

    public int getNumOfRecords() {
        return records.length;
    }
}
