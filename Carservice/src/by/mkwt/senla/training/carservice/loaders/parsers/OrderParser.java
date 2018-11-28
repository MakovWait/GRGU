package by.mkwt.senla.training.carservice.loaders.parsers;

import by.mkwt.senla.training.carservice.loaders.ItemParser;
import by.mkwt.senla.training.carservice.loaders.LoaderComponent;
import by.mkwt.senla.training.carservice.logic.models.items.Order;
import by.mkwt.senla.training.carservice.logic.models.items.OrderState;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class OrderParser implements ItemParser<Order> {

    private static Logger logger = Logger.getLogger(OrderParser.class);

    private static SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    public Order getItemFrom(String line) {
        String[] values = line.split(LoaderComponent.DELIMITER);

        Order tmpOrder = new Order();

        tmpOrder.setId(Long.parseLong(values[0]));

        try {
            tmpOrder.setFillingDate(format.parse(values[1]));
            tmpOrder.setStartingDate(format.parse(values[2]));
            tmpOrder.setEndingDate(format.parse(values[3]));
        } catch (ParseException e) {
            logger.error(e);

            return null;
        }

        tmpOrder.setPrice(new BigDecimal(values[4]));
        tmpOrder.setState(OrderState.valueOf(values[5]));

        return tmpOrder;
    }

    @Override
    public String[] getLineMassFrom(Order item) {
        return new String[]{
                String.valueOf(item.getId()),
                String.valueOf(item.getFillingDate()),
                String.valueOf(item.getStartingDate()),
                String.valueOf(item.getEndingDate()),
                String.valueOf(item.getPrice()),
                String.valueOf(item.getState())
        };
}

}
