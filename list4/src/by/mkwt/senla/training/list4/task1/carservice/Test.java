package by.mkwt.senla.training.list4.task1.carservice;

import by.mkwt.senla.training.list4.task1.carservice.models.managers.GarageManager;
import by.mkwt.senla.training.list4.task1.carservice.models.managers.OrderManager;
import by.mkwt.senla.training.list4.task1.carservice.utils.sorters.comparators.order.OrderCompareTypes;
import by.mkwt.senla.training.list4.task1.carservice.utils.Printer;
import by.mkwt.senla.training.list4.task1.carservice.utils.RequestManager;

import java.util.ArrayList;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        RequestManager requestManager = new RequestManager();
        Printer.print(new ArrayList<>(requestManager.getEmptyGarages()));

        Printer.print(new ArrayList<>(requestManager.getOrderListSortedBy(OrderCompareTypes.byFillingDate)));
        Printer.print(new ArrayList<>(requestManager.getOrderListSortedBy(OrderCompareTypes.byEndingDate)));
        Printer.print(new ArrayList<>(requestManager.getOrderListSortedBy(OrderCompareTypes.byStartingDate)));
        Printer.print(new ArrayList<>(requestManager.getOrderListSortedBy(OrderCompareTypes.byPrice)));

        Printer.print(new ArrayList<>(requestManager.getActiveOrders()));

        OrderManager orderManager = new OrderManager();
        orderManager.buildItemListFromFile();

        Printer.print(new ArrayList<>(requestManager.getMechanicsByOrder(orderManager.getOrderByID(1l))));

        Date date = new Date(0l);
        System.out.print(date.getTime());
    }
}
