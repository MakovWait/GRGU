package by.mkwt.senla.training.list4.task1.carservice.utils.sorters;

import by.mkwt.senla.training.list4.task1.carservice.utils.sorters.comparators.order.OrderComparator;
import by.mkwt.senla.training.list4.task1.carservice.utils.sorters.comparators.order.OrderCompareTypes;

public class OrderSorter {
    private OrderComparator orderComparator;

    public OrderSorter() {
        orderComparator = new OrderComparator();
    }

    public OrderComparator orderBy(OrderCompareTypes type) {
        orderComparator.setCompareType(type);
        return orderComparator;
    }
}
