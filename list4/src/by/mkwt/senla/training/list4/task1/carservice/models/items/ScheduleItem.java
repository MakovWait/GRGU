package by.mkwt.senla.training.list4.task1.carservice.models.items;

import by.mkwt.senla.training.list4.task1.carservice.table.structure.field.Field;
import by.mkwt.senla.training.list4.task1.carservice.table.structure.record.Record;

import java.util.Date;
import java.util.List;

public class ScheduleItem extends Record {

    public static String ORDER_ID = "orderId";
    public static String MECHANIC_ID = "mechanicId";
    public static String GARAGE_ID = "garageId";

    public ScheduleItem(Date date, Long orderID, Long mechanicID, Long garageID) {
        super.addField(new Field<>(ORDER_ID, orderID))
                .addField(new Field<>(MECHANIC_ID, mechanicID))
                .addField(new Field<>(GARAGE_ID, garageID));
    }

    public ScheduleItem(List<Field> fields) {
        super(fields);
    }

    public long getOrderId() {
        return (long) super.getFieldByName(ORDER_ID).getValue();
    }

    public long getMechanicId() {
        return (long) super.getFieldByName(MECHANIC_ID).getValue();
    }

    public long getGarageId() {
        return (long) super.getFieldByName(GARAGE_ID).getValue();
    }
}
