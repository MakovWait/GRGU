package by.mkwt.senla.training.list4.task1.carservice.table.utils.builders;

import by.mkwt.senla.training.list4.task1.carservice.table.structure.field.Field;
import by.mkwt.senla.training.list4.task1.carservice.table.structure.field.FieldType;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FieldBuilder {
    public static Field buildField(String fieldName, String value, FieldType type) {
        switch (type) {
            case STRING:
                return new Field<>(fieldName, value);
            case LONG:
                return new Field<>(fieldName, Long.parseLong(value));
            case INTEGER:
                return new Field<>(fieldName, Integer.parseInt(value));
            case BIG_DECIMAL:
                return new Field<>(fieldName, new BigDecimal(value));
            case DATE:
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", new Locale("us"));
                    return new Field<>(fieldName, new Date(sdf.parse(value).getTime()));
                } catch (ParseException e) {

                }
            default:
                throw new IllegalArgumentException();
        }
    }
}
