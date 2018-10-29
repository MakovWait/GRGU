package by.mkwt.senla.training.list4.task1.carservice.models.items;

import by.mkwt.senla.training.list4.task1.carservice.table.structure.field.Field;
import by.mkwt.senla.training.list4.task1.carservice.table.structure.record.Record;

import java.util.List;

public class Mechanic extends Record {

    public static final String ID = "mechanicId";
    public static final String NAME = "mechanicName";

    public static final String BUSINESS = "busyness";

    public Mechanic(long id, String name) {
        super.addField(new Field<>(ID, id))
                .addField(new Field<>(NAME, name));
    }

    public void setBusyness(int busyness) {
        super.addField(new Field<>(BUSINESS, busyness));
    }

    public Mechanic(List<Field> fields) {
        super(fields);
    }

    public long getId() {
        return (long) super.getFieldByName(ID).getValue();
    }

    public String getName() {
        return (String) super.getFieldByName(NAME).getValue();
    }
}
