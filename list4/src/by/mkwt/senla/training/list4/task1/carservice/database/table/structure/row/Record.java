package by.mkwt.senla.training.list4.task1.carservice.database.table.structure.row;

import by.mkwt.senla.training.list4.task1.carservice.database.table.structure.field.Field;

public class Record {
    Field[] fields;

    public Record(Field[] fields) {
        this.fields = fields;
    }

    public Field getFieldByIndex(int index) {
        return fields[index];
    }
    public Field[] getAllFields() {
        return fields;
    }
}
