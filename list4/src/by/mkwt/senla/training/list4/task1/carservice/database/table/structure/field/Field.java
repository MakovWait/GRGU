package by.mkwt.senla.training.list4.task1.carService.database.table.structure.field;

public class Field<T extends Comparable<T>> implements Comparable<Field<T>>{
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


    @Override
    public int compareTo(Field<T> o) {
        return value.compareTo(o.value);
    }
}
