package by.mkwt.senla.training.list4.task1.carservice;

import by.mkwt.senla.training.list4.task1.carservice.models.managers.OrderManager;
import by.mkwt.senla.training.list4.task1.carservice.utils.sorters.comparators.order.OrderCompareTypes;
import by.mkwt.senla.training.list4.task1.carservice.utils.Printer;
import by.mkwt.senla.training.list4.task1.carservice.utils.RequestManager;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Printer.print(new ArrayList<>(RequestManager.getEmptyGarages()));

        Printer.print(new ArrayList<>(RequestManager.getOrderListSortedBy(OrderCompareTypes.byFillingDate)));
        Printer.print(new ArrayList<>(RequestManager.getOrderListSortedBy(OrderCompareTypes.byEndingDate)));
        Printer.print(new ArrayList<>(RequestManager.getOrderListSortedBy(OrderCompareTypes.byStartingDate)));
        Printer.print(new ArrayList<>(RequestManager.getOrderListSortedBy(OrderCompareTypes.byPrice)));

        Printer.print(new ArrayList<>(RequestManager.getActiveOrders()));

        OrderManager orderManager = new OrderManager();
        orderManager.buildItemListFromFile();

        Printer.print(new ArrayList<>(RequestManager.getMechanicsByOrder(orderManager.getOrderByID(1l))));


    }
}
