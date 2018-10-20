package by.mkwt.senla.training.list4.task1.carservice.database.utils.builders.table;

import by.mkwt.senla.training.list4.task1.carservice.database.table.Table;
import by.mkwt.senla.training.list4.task1.carservice.database.table.structure.field.Field;
import by.mkwt.senla.training.list4.task1.carservice.database.utils.builders.field.FieldBuilder;
import by.mkwt.senla.training.list4.task1.carservice.database.table.structure.record.Record;
import by.mkwt.senla.training.list4.task1.carservice.database.utils.textutils.record.RecordParser;
import by.mkwt.senla.training.list4.task1.carservice.database.utils.textutils.table.TableReader;

public class TableBuilder {

    private static TableReader readerComponent;

    public static Table buildTableFromFile(String pathToTable, String pathToTableDescription) {
        readerComponent = new TableReader(pathToTable, pathToTableDescription);
        Record[] records = new Record[readerComponent.getAllTableRecords().length];

        Field[] tmpFields;

        String tableName = readerComponent.getTableName();
        String[] fieldNames = RecordParser.getValues(readerComponent.getTableFieldsNames());
        String[] fieldTypes = RecordParser.getValues(readerComponent.getTableFieldsTypes());
        String[] recordValues;

        for (int i = 0; i < records.length; i++) {
            recordValues = RecordParser.getValues(readerComponent.getAllTableRecords()[i]);
            tmpFields = new Field[fieldNames.length];
            for (int j = 0; j < tmpFields.length; j++) {

                tmpFields[j] = FieldBuilder.buildField(fieldNames[j], recordValues[j], fieldTypes[j]);
            }
            records[i] = new Record(tmpFields);
        }
        return new Table(tableName, fieldNames, records);
    }
}
