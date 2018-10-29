package by.mkwt.senla.training.list4.task1.carservice.models;

import by.mkwt.senla.training.list4.task1.carservice.logic.RequestMaster;
import by.mkwt.senla.training.list4.task1.carservice.models.items.Mechanic;
import by.mkwt.senla.training.list4.task1.carservice.models.items.Order;
import by.mkwt.senla.training.list4.task1.carservice.models.items.OrderState;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        RequestMaster requestMaster = new RequestMaster();

        System.out.println(requestMaster.getEmptyGarages());

        System.out.println(requestMaster.getAllOrders().toString());
        System.out.println(requestMaster.getAllOrdersOrderedBy(Order.FILLING_DATE));
        System.out.println(requestMaster.getAllOrdersOrderedBy(Order.ENDING_DATE));
        System.out.println(requestMaster.getAllOrdersOrderedBy(Order.STARTING_DATE));
        System.out.println(requestMaster.getAllOrdersOrderedBy(Order.PRICE));

        System.out.println(requestMaster.getAllMechanics());
        System.out.println(requestMaster.getAllMechanicsOrderedBy(Mechanic.NAME));
        System.out.println(requestMaster.getAllMechanicsOrderedByBusyness());

        System.out.println(requestMaster.getActiveOrders());
        System.out.println(requestMaster.getActiveOrdersOrderedBy(Order.FILLING_DATE));
        System.out.println(requestMaster.getActiveOrdersOrderedBy(Order.STARTING_DATE));
        System.out.println(requestMaster.getActiveOrdersOrderedBy(Order.PRICE));

        System.out.println(requestMaster.getMechanicsByOrderId(1));
        System.out.println(requestMaster.getOrderByMechanicId(1));

        System.out.println(requestMaster.getOrdersInPeriod(OrderState.Completed, new Date(0), new Date()));
        System.out.println(requestMaster.getOrdersInPeriod(OrderState.Closed, new Date(0), new Date()));
        System.out.println(requestMaster.getOrdersInPeriod(OrderState.Canceled, new Date(0), new Date()));

        System.out.println(requestMaster.getNumOfFreeSpacesInCarService());

        System.out.println(requestMaster.getNearestFreeDate());
    }
}
