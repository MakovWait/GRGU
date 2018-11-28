package by.mkwt.senla.training.carservice.loaders.parsers;


import by.mkwt.senla.training.carservice.loaders.ItemParser;
import by.mkwt.senla.training.carservice.loaders.LoaderComponent;
import by.mkwt.senla.training.carservice.logic.exceptions.IllegalItemLineImplException;
import by.mkwt.senla.training.carservice.logic.models.items.ScheduleItem;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduleParser implements ItemParser<ScheduleItem> {

    private static Logger logger = Logger.getLogger(OrderParser.class);

    private static SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    public ScheduleItem getItemFrom(String line) {
        String[] values = line.split(LoaderComponent.DELIMITER);

        ScheduleItem tmpScheduleItem = new ScheduleItem();

        try {
            tmpScheduleItem.setDate(format.parse(values[0]));
        } catch (ParseException e) {
            logger.error(e);

            return null;
        }

        tmpScheduleItem.setOrderId(Long.parseLong(values[1]));
        tmpScheduleItem.setMechanicId(Long.parseLong(values[2]));
        tmpScheduleItem.setGarageId(Long.parseLong(values[3]));

        return tmpScheduleItem;
    }

    @Override
    public String[] getLineMassFrom(ScheduleItem item) {
        return new String[]{
                String.valueOf(item.getDate()),
                String.valueOf(item.getOrderId()),
                String.valueOf(item.getMechanicId()),
                String.valueOf(item.getGarageId())
        };
    }
}
