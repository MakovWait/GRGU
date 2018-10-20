package by.mkwt.senla.training.list4.task1.carservice.database.utils.builders.field;

import by.mkwt.senla.training.list4.task1.carservice.database.table.structure.field.Field;
import by.mkwt.senla.training.list4.task1.carservice.database.table.structure.field.FieldType;

public class FieldBuilder {
    public static Field buildField(String fieldName, String value, String type) {
        switch (FieldType.valueOf(type)){
            case STRING:
                return new Field<String>(fieldName, value);
            case INTEGER:
                return new Field<Integer>(fieldName, Integer.parseInt(value));
            case FLOAT:
                return new Field<Float>(fieldName, Float.parseFloat(value));
            default:
                throw new IllegalArgumentException();
        }
    }
}
