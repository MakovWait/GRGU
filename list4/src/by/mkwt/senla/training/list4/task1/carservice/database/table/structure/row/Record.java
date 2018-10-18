package by.mkwt.senla.training.list4.task1.carService.database.table.structure.row;

import by.mkwt.senla.training.list4.task1.carService.database.table.structure.field.Field;

public class Record {
    private Field[] fields;

    public Record(Field[] fields) {
        this.fields = fields;
    }

    public Field getFieldByName(String name) {
        for(Field field : fields) {
            if(field.getFieldName().equals(name)) return field;
        }
        throw new IllegalArgumentException();
    }

    public Field getFieldByIndex(int index) {
        return fields[index];
    }

    public Field[] getAllFields() {
        return fields;
    }

}
