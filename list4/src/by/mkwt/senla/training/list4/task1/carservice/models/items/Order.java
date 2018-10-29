package by.mkwt.senla.training.list4.task1.carservice.models.items;

import by.mkwt.senla.training.list4.task1.carservice.table.structure.field.Field;
import by.mkwt.senla.training.list4.task1.carservice.table.structure.record.Record;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Order extends Record {

    public static String ID = "orderId";
    public static String FILLING_DATE = "fillingDate";
    public static String STARTING_DATE = "startingDate";
    public static String ENDING_DATE = "endingDate";
    public static String PRICE = "price";
    public static String STATE = "state";

    public Order(Long id, Date fillingDate, Date startingDate, Date endingDate, BigDecimal price, OrderState state) {
        super.addField(new Field<>(ID, id))
                .addField(new Field<>(FILLING_DATE, fillingDate))
                .addField(new Field<>(STARTING_DATE, startingDate))
                .addField(new Field<>(ENDING_DATE, endingDate))
                .addField(new Field<>(PRICE, price))
                .addField(new Field<>(STATE, state));
    }

    public Order(List<Field> fields) {
        super(fields);
    }

    public long getId() {
        return (long) super.getFieldByName(ID).getValue();
    }

    public Date getFillingDate() {
        return (Date) super.getFieldByName(FILLING_DATE).getValue();
    }

    public Date getStartingDate() {
        return (Date) super.getFieldByName(STARTING_DATE).getValue();
    }

    public Date getEndingDate() {
        return (Date) super.getFieldByName(ENDING_DATE).getValue();
    }

    public float getPrice() {
        return (float) super.getFieldByName(PRICE).getValue();
    }

    public OrderState getOrderState() {
        return OrderState.valueOf((String) super.getFieldByName(STATE).getValue());
    }
}
