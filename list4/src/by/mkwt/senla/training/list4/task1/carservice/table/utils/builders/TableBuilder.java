package by.mkwt.senla.training.list4.task1.carservice.table.utils.builders;

import by.mkwt.senla.training.list4.task1.carservice.table.structure.Table;
import by.mkwt.senla.training.list4.task1.carservice.table.structure.field.Field;
import by.mkwt.senla.training.list4.task1.carservice.table.structure.field.FieldType;
import by.mkwt.senla.training.list4.task1.carservice.table.structure.record.Record;
import by.mkwt.senla.training.list4.task1.carservice.table.utils.textutils.record.RecordParser;
import by.mkwt.senla.training.list4.task1.carservice.table.utils.textutils.table.TableReader;

import java.util.ArrayList;
import java.util.List;

public class TableBuilder {

    private static TableReader readerComponent;

    public static final String VALUES = "values.txt";
    private static final String DESCRIPTION = "description.txt";

    public static Table buildTableFromFile(String pathToTable) {
        readerComponent = new TableReader(pathToTable + VALUES, pathToTable + DESCRIPTION);
        ArrayList<Record> records = new ArrayList<>();

        List<Field> tmpFields;

        String tableName = readerComponent.getTableName();
        List<String> fieldNames = RecordParser.getValues(readerComponent.getTableFieldsNames());
        List<String> fieldTypes = RecordParser.getValues(readerComponent.getTableFieldsTypes());
        List<String> recordValues;

        for (int i = 0; i < readerComponent.getAllTableRecords().length; i++) {
            recordValues = RecordParser.getValues(readerComponent.getAllTableRecords()[i]);
            tmpFields = new ArrayList<>();
            for (int j = 0; j < fieldNames.size(); j++) {

                tmpFields.add(FieldBuilder.buildField(
                        fieldNames.get(j),
                        recordValues.get(j),
                        FieldType.valueOf(fieldTypes.get(j))
                ));
            }
            records.add(new Record(tmpFields));
        }
        return buildCustomTable(tableName, fieldNames, records);
    }

    public static Table buildCustomTable(String tableName, List<String> fieldsName, List<Record> records) {
        return new Table(tableName, fieldsName, records);
    }
}
