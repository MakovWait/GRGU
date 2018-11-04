package by.mkwt.senla.training.carservice.loaders.parsers;


import by.mkwt.senla.training.carservice.loaders.ItemParser;
import by.mkwt.senla.training.carservice.loaders.LoaderComponent;
import by.mkwt.senla.training.carservice.models.items.ScheduleItem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduleParser implements ItemParser<ScheduleItem> {

    private static SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    public ScheduleItem getItemFrom(String line) {
        String[] values = line.split(LoaderComponent.DELIMITER);

        ScheduleItem tmpScheduleItem = new ScheduleItem();

        try {
            tmpScheduleItem.setDate(format.parse(values[0]));

        } catch (ParseException e) {
            tmpScheduleItem.setDate(new Date(0));
        }

        tmpScheduleItem.setOrderId(Long.parseLong(values[1]));
        tmpScheduleItem.setMechanicId(Long.parseLong(values[2]));
        tmpScheduleItem.setGarageId(Long.parseLong(values[3]));

        return tmpScheduleItem;
    }

    @Override
    public String getLineFrom(ScheduleItem item) {
        String[] result = new String[]{
                String.valueOf(item.getDate()),
                String.valueOf(item.getOrderId()),
                String.valueOf(item.getMechanicId()),
                String.valueOf(item.getGarageId())
        };

        return String.join(LoaderComponent.BORDER, result);
    }

}
