package by.mkwt.senla.training.carservice;

import by.mkwt.senla.training.carservice.logic.RequestMaster;
import by.mkwt.senla.training.carservice.models.items.OrderState;
import by.mkwt.senla.training.carservice.sorters.MechanicOrderableValues;
import by.mkwt.senla.training.carservice.sorters.OrderOrderableValues;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        RequestMaster requestMaster = new RequestMaster();

        System.out.println(requestMaster.getEmptyGarages());

        System.out.println(requestMaster.getAllOrders().toString());
        System.out.println(requestMaster.getAllOrdersOrderedBy(OrderOrderableValues.byFillingDate));
        System.out.println(requestMaster.getAllOrdersOrderedBy(OrderOrderableValues.byEndingDate));
        System.out.println(requestMaster.getAllOrdersOrderedBy(OrderOrderableValues.byStartingDate));
        System.out.println(requestMaster.getAllOrdersOrderedBy(OrderOrderableValues.byPrice));

        System.out.println(requestMaster.getAllMechanics());
        System.out.println(requestMaster.getAllMechanicsOrderedBy(MechanicOrderableValues.byName));
        System.out.println(requestMaster.getAllMechanicsOrderedByBusyness());

        System.out.println(requestMaster.getActiveOrders());
        System.out.println(requestMaster.getActiveOrdersOrderedBy(OrderOrderableValues.byFillingDate));
        System.out.println(requestMaster.getActiveOrdersOrderedBy(OrderOrderableValues.byEndingDate));
        System.out.println(requestMaster.getActiveOrdersOrderedBy(OrderOrderableValues.byPrice));

        System.out.println(requestMaster.getMechanicsByOrderId(1));
        System.out.println(requestMaster.getOrderByMechanicId(1));

        System.out.println(requestMaster.getOrdersInPeriod(OrderState.Completed, new Date(0), new Date()));
        System.out.println(requestMaster.getOrdersInPeriod(OrderState.Closed, new Date(0), new Date()));
        System.out.println(requestMaster.getOrdersInPeriod(OrderState.Canceled, new Date(0), new Date()));

        System.out.println(requestMaster.getNumOfFreeSpacesInCarService());

        System.out.println(requestMaster.getNearestFreeDate());


    }
}
