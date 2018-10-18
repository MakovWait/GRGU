package by.mkwt.senla.training.list4.task1.carService.database.table.structure.field;

public class FieldBuilder {
    public static Field buildField(String fieldName, String value, String type) {
        switch (FieldType.valueOf(type)){
            case string:
                return new Field<String>(fieldName, value);
            case integer:
                return new Field<Integer>(fieldName, Integer.parseInt(value));
            case float_:
                return new Field<Float>(fieldName, Float.parseFloat(value));
            default:
                throw new IllegalArgumentException();
        }
    }
}
