package by.mkwt.senla.training.carservice.models.managers;

import by.mkwt.senla.training.carservice.loaders.LoaderComponent;
import by.mkwt.senla.training.carservice.loaders.parsers.OrderParser;
import by.mkwt.senla.training.carservice.models.items.Order;
import by.mkwt.senla.training.carservice.models.items.OrderState;
import by.mkwt.senla.training.carservice.sorters.OrderOrderableValues;
import by.mkwt.senla.training.carservice.sorters.OrderSorter;

import java.util.*;

public class OrderManager {

    private LoaderComponent<Order> loader;
    private OrderSorter sorter;
    private Map<Long, Order> orders;

    public OrderManager(final String PATH_TO_FILE) {
        loader = new LoaderComponent<>(new OrderParser(), PATH_TO_FILE);
        sorter = new OrderSorter();

        loadAllOrders();
    }

    public void addOrder(Order order) {
        if (!orders.containsKey(order.getId())) {
            orders.put(order.getId(), order);
            saveOrders();
        }
    }

    public void removeOrderById(long id) {
        if (orders.containsKey(id)) {
            orders.remove(id);
            saveOrders();
        }
    }

    private void saveOrders() {
        loader.writeItemsToFile(orders.values());
    }

    public void changeOrderStateById(long id, OrderState newState) {
        getOrderById(id).setState(newState);
    }

    private void loadAllOrders() {
        orders = new HashMap<>();

        Order order;
        while ((order = loader.getNextItem()) != null) {
            orders.put(order.getId(), order);
        }
    }

    public List<Order> getAllOrders() {

        return new ArrayList<>(orders.values());
    }

    public List<Order> getAllOrdersBy(OrderState state) {
        Set<Order> result = new HashSet<>();

        for (Order order : orders.values()) {
            if (order.getState() == state) {
                result.add(order);
            }
        }

        return new ArrayList<>(result);
    }

    public Collection<Order> getOrders() {

        return orders.values();
    }

    public Order getOrderById(long id) {
        return orders.get(id);
    }

    public void shiftEndingDates(List<Order> neededToChangeOrders, long shiftedTime) {
        Date currentDate;

        getAllOrders().removeAll(neededToChangeOrders);

        for (Order changeableOrder : neededToChangeOrders) {
            currentDate = changeableOrder.getEndingDate();

            changeableOrder.setEndingDate(new Date(currentDate.getTime() + shiftedTime));
        }

        getAllOrders().addAll(neededToChangeOrders);
        saveOrders();
    }

    public List<Order> orderBy(OrderOrderableValues value) {
        return sorter.orderBy(value, getAllOrders());
    }
}
