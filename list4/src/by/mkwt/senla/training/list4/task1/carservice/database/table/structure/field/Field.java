package by.mkwt.senla.training.list4.task1.carservice.database.table.structure.field;

public class Field<T> {
    private String name;
    private T value;

    public Field(String name, T value) {
        this.name = name;
        this.value = value;
    }

    public String getFieldName() {
        return name;
    }

    public T getValue() {
        return value;
    }
}
