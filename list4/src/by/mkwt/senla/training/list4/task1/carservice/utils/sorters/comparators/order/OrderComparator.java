package by.mkwt.senla.training.list4.task1.carservice.utils.sorters.comparators.order;

import by.mkwt.senla.training.list4.task1.carservice.models.items.Order;

import java.util.Comparator;

public class OrderComparator implements Comparator<Order> {

    OrderCompareTypes type;

    public OrderComparator() {
        type = OrderCompareTypes.byPrice;
    }

    @Override
    public int compare(Order o1, Order o2) {
        switch (type) {
            case byFillingDate:
                return o1.getFillingDate().compareTo(o2.getFillingDate());
            case byPrice:
                return o1.getPrice().compareTo(o2.getPrice());
            case byStartingDate:
                return o1.getStartingDate().compareTo(o2.getStartingDate());
            case byEndingDate:
                return o1.getEndingDate().compareTo(o2.getEndingDate());
            default:
                return 0;
        }
    }

    public void setCompareType(OrderCompareTypes type) {
        this.type = type;
    }
}
