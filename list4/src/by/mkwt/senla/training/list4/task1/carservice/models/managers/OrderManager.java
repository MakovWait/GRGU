package by.mkwt.senla.training.list4.task1.carservice.models.managers;

import by.mkwt.senla.training.list4.task1.carservice.utils.file.OrderFileUtil;
import by.mkwt.senla.training.list4.task1.carservice.models.items.Order;
import by.mkwt.senla.training.list4.task1.carservice.models.items.OrderState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class OrderManager implements ItemManager<Order> {

    private ArrayList<Order> orders;
    private OrderFileUtil orderFileUtil = new OrderFileUtil();

    @Override
    public void buildItemListFromFile() {

        orders = new ArrayList<>(Arrays.asList(orderFileUtil.readFromFile()));
    }

    @Override
    public void addItem(Order order) {
        if (orders == null) {
            System.out.print("The orders should be initialized first");
            return;
        }

        if (!orders.contains(order)) {
            orders.add(order);
        } else {
            System.out.print("This order is already exist");
        }
        saveItemList();
    }

    @Override
    public void removeItem(Order order) {
        orders.remove(order);
        saveItemList();
    }

    @Override
    public void saveItemList() {
        orderFileUtil.writeToFile(orders.toArray(new Order[orders.size()]));
    }

    @Override
    public void print() {
        for (Order item : orders) {
            System.out.println(item.toLine());
        }
    }

    public void changeItemState(Order currentOrder, OrderState newState) {
        orders.get(orders.indexOf(currentOrder)).setState(newState);
    }

    public void shiftEndingDates(ArrayList<Order> dependentOrders, Date shiftedValue) {
        ArrayList<Order> neededToChangeOrders = new ArrayList<>(orders);
        neededToChangeOrders.retainAll(dependentOrders);

        for (Order changeableOrder : neededToChangeOrders) {
            changeableOrder.shiftEndingDate(shiftedValue);
        }
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
}
