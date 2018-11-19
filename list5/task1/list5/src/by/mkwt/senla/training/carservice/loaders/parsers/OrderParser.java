package by.mkwt.senla.training.carservice.loaders.parsers;

import by.mkwt.senla.training.carservice.loaders.ItemParser;
import by.mkwt.senla.training.carservice.loaders.LoaderComponent;
import by.mkwt.senla.training.carservice.logic.models.items.Order;
import by.mkwt.senla.training.carservice.logic.models.items.OrderState;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class OrderParser implements ItemParser<Order> {

    private static SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    public Order getItemFrom(String line) {
        String[] values = line.split(LoaderComponent.DELIMITER);

        Order tmpOrder = new Order();

        if (values.length > 0) {
            tmpOrder.setId(Long.parseLong(values[0]));

            try {
                tmpOrder.setFillingDate(format.parse(values[1]));
                tmpOrder.setStartingDate(format.parse(values[2]));
                tmpOrder.setEndingDate(format.parse(values[3]));
            } catch (ParseException e) {
                tmpOrder.setFillingDate(new Date(0));
                tmpOrder.setStartingDate(new Date(0));
                tmpOrder.setEndingDate(new Date(0));
            }

            tmpOrder.setPrice(new BigDecimal(values[4]));
            tmpOrder.setState(OrderState.valueOf(values[5]));
        }

        return tmpOrder;
    }

    @Override
    public String getLineFrom(Order item) {
        String[] result = new String[]{
                String.valueOf(item.getId()),
                String.valueOf(item.getFillingDate()),
                String.valueOf(item.getStartingDate()),
                String.valueOf(item.getEndingDate()),
                String.valueOf(item.getPrice()),
                String.valueOf(item.getState())
        };

        return String.join(LoaderComponent.BORDER, result);
    }

}
