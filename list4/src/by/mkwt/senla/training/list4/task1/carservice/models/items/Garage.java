package by.mkwt.senla.training.list4.task1.carservice.models.items;

import by.mkwt.senla.training.list4.task1.carservice.table.structure.field.Field;
import by.mkwt.senla.training.list4.task1.carservice.table.structure.record.Record;

import java.util.List;

public class Garage extends Record {

    public static final String ID = "garageId";

    public Garage(long id) {
        super.addField(new Field<>(ID, id));
    }

    public Garage(List<Field> fields) {
        super(fields);
    }

    public long getId() {
        return (long) super.getFieldByName(ID).getValue();
    }
}
