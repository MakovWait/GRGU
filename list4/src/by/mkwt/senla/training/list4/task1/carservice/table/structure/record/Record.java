package by.mkwt.senla.training.list4.task1.carservice.table.structure.record;

import by.mkwt.senla.training.list4.task1.carservice.table.structure.field.Field;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Record {
    private List<Field> fields;

    public Record() {
        fields = new ArrayList<>();
    }

    public Record(List<Field> fields) {

        this.fields = fields;
    }

    public Record addField(Field field) {
        fields.add(field);
        return this;
    }

    public void setField(Field oldField, Field newField) {
        fields.remove(getFieldByName(oldField.getFieldName()));
        fields.add(newField);
    }

    public Field getFieldByName(String name) {
        for (Field field : fields) {
            if (field.getFieldName().equals(name)) {
                return field;
            }
        }
        throw new IllegalArgumentException();
    }

    public Field getFieldByIndex(int index) {
        return fields.get(index);
    }

    public List<Field> getAllFields() {
        return fields;
    }

    @Override
    public String toString() {
        ArrayList<String> result = new ArrayList<>();

        for (Field field : fields) {
            result.add(" " + field.getFieldName() + " : " + field.getValue());
        }

        return String.join(";", result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Objects.equals(fields, record.fields);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fields);
    }
}
