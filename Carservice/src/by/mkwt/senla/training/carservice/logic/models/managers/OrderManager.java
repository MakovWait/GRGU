package by.mkwt.senla.training.carservice.logic.models.managers;

import by.mkwt.senla.training.carservice.loaders.LoaderComponent;
import by.mkwt.senla.training.carservice.loaders.parsers.OrderParser;
import by.mkwt.senla.training.carservice.logic.annotations.AppConfig;
import by.mkwt.senla.training.carservice.logic.annotations.ConfigProperty;
import by.mkwt.senla.training.carservice.logic.annotations.Loadable;
import by.mkwt.senla.training.carservice.logic.exceptions.IllegalIdException;
import by.mkwt.senla.training.carservice.logic.exceptions.IllegalItemLineImplException;
import by.mkwt.senla.training.carservice.logic.exceptions.ItemIsAlreadyExistException;
import by.mkwt.senla.training.carservice.logic.exceptions.NoSuchItemException;
import by.mkwt.senla.training.carservice.logic.models.items.Mechanic;
import by.mkwt.senla.training.carservice.logic.models.items.Order;
import by.mkwt.senla.training.carservice.logic.models.items.OrderState;
import by.mkwt.senla.training.carservice.logic.models.sorters.OrderOrderableValues;
import by.mkwt.senla.training.carservice.logic.models.sorters.OrderSorter;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.io.FileNotFoundException;
import java.util.*;

@AppConfig
public class OrderManager {

    @ConfigProperty(propertyName = "bin.path_to_orders")
    private String pathToFile = null;

    @ConfigProperty(propertyName = "db.path_to_csv_orders")
    private String pathToCsvFile = null;

    private LoaderComponent<Order> loader;
    private OrderSorter sorter;
    private Map<Long, Order> orders;

    public OrderManager() {
        sorter = new OrderSorter();
    }

    public void addOrder(Order order) throws IllegalIdException, ItemIsAlreadyExistException {
        if (order == null || order.getId() == null) {
            throw new IllegalIdException();
        }

        if (orders.containsKey(order.getId())) {
            throw new ItemIsAlreadyExistException();
        }

        orders.put(order.getId(), order);
        saveOrders();
    }

    public void updateOrder(Order order) {
        orders.put(order.getId(), order);
        saveOrders();
    }

    public void importFromCsv() throws FileNotFoundException {
        List<Order> importItems = loader.getItemsFromCsvFile();

        for (Order item : importItems) {
            orders.put(item.getId(), item);
        }
    }

    public void exportToCsv() {
        loader.writeItemsToCsvFile(getAllOrders());
    }

    public void removeOrderById(Long id) throws NoSuchItemException {
        if (id != null && orders.containsKey(id)) {
            orders.remove(id);
            saveOrders();
        }

        if (!orders.containsKey(id)) {
            throw new NoSuchItemException();
        }

        orders.remove(id);
        saveOrders();
    }

    public void changeOrderStateById(long id, OrderState newState) throws IllegalIdException {
        if(getOrderById(id) == null) {
            throw new IllegalIdException();
        }

        getOrderById(id).setState(newState);
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

    public Order getOrderByIdInCustomArray(List<Order> orders, long id) {
        if (orders == null) {
            return null;
        }

        for (Order order : orders) {
            if (order.getId().equals(id)) {
                return order;
            }
        }

        return null;
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

    public Order getOrderFromLine(String line) {
        return loader.getItemFromLine(line);
    }

    @Loadable
    private void loadAllOrders() {
        loader = new LoaderComponent<>(new OrderParser(), pathToFile, pathToCsvFile);

        orders = new HashMap<>();

        loader.start();
        Order order;
        while ((order = loader.getNextItem()) != null) {
            orders.put(order.getId(), order);
        }
        loader.stop();
    }

    private void saveOrders() {
        loader.writeItemsToFile(orders.values());
    }
}
