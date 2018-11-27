package by.mkwt.senla.training.carservice.logic.models.sorters;

import by.mkwt.senla.training.carservice.logic.models.items.Order;

import java.util.Collections;
import java.util.List;

public class OrderSorter {

    public List<Order> orderBy(OrderOrderableValues value, List<Order> orders) {
        switch (value){
            case byStartingDate:
                return orderByStartingDate(orders);
            case byEndingDate:
                return orderByEndingDate(orders);
            case byFillingDate:
                return orderByFillingDate(orders);
            case byPrice:
                return orderByPrice(orders);
            default:
                return orders;
        }
    }

    private List<Order> orderByStartingDate(List<Order> orders) {
        Collections.sort(orders, (o1, o2) -> o1.getStartingDate().compareTo(o2.getStartingDate()));

        return orders;
    }

    private List<Order> orderByEndingDate(List<Order> orders) {
        Collections.sort(orders, (o1, o2) -> o1.getEndingDate().compareTo(o2.getEndingDate()));

        return orders;
    }

    private List<Order> orderByFillingDate(List<Order> orders) {
        Collections.sort(orders, (o1, o2) -> o1.getFillingDate().compareTo(o2.getFillingDate()));

        return orders;
    }

    private List<Order> orderByPrice(List<Order> orders) {
        Collections.sort(orders, (o1, o2) -> o1.getPrice().compareTo(o2.getPrice()));

        return orders;
    }

}
