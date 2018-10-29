package by.mkwt.senla.training.list4.task1.carservice.models.managers;

import by.mkwt.senla.training.list4.task1.carservice.table.structure.Table;
import by.mkwt.senla.training.list4.task1.carservice.table.structure.field.Field;
import by.mkwt.senla.training.list4.task1.carservice.table.structure.record.Record;
import by.mkwt.senla.training.list4.task1.carservice.table.utils.builders.TableBuilder;
import by.mkwt.senla.training.list4.task1.carservice.table.utils.sorter.RecordSorter;
import by.mkwt.senla.training.list4.task1.carservice.table.utils.textutils.table.TableWriter;
import by.mkwt.senla.training.list4.task1.carservice.models.items.Order;
import by.mkwt.senla.training.list4.task1.carservice.models.items.OrderState;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderManager {

    private Table orderTable;
    private final String PATH_TO_TABLE = "./resources/table/tables/orders/";

    private List<Order> orders;

    public OrderManager() {
        orderTable = TableBuilder.buildTableFromFile(PATH_TO_TABLE);
        loadAllOrders();
    }

    public void addOrder(Order order) {
        orderTable.getAllRecords().add(order);
        saveOrders();
    }

    public void removeOrderById(long id) {
        orderTable.getAllRecords().remove(getOrderById(id));
        saveOrders();
    }

    private void saveOrders() {
        TableWriter.writeToFile(PATH_TO_TABLE, orderTable);
    }

    public void changeOrderStateById(long id, OrderState newState) {
        int orderIndexInTable = orderTable.getAllRecords().indexOf(getOrderById(id));
        Field oldField = orderTable.getAllRecords().get(orderIndexInTable).getFieldByName(Order.STATE);
        Field newField = new Field<>(Order.STATE, newState);

        orderTable.getAllRecords().get(orderIndexInTable).setField(oldField, newField);
        saveOrders();

    }

    private void loadAllOrders() {
        List<Order> result = new ArrayList<>();

        for (Record record : orderTable.getAllRecords()) {
            result.add(new Order(record.getAllFields()));
        }

        orders = result;
    }

    public List<Order> getAllOrders() {

        return orders;
    }

    public List<Order> getOrders(OrderState orderState) {

        if (orderState == null) {
            return getAllOrders();
        }

        List<Order> result = new ArrayList<>();

        for (Order order : getAllOrders()) {
            if (order.getOrderState().equals(orderState)) {
                result.add(order);
            }
        }

        return result;
    }

    public Order getActiveOrderById(long id) {
        for (Order order : getOrders(OrderState.inProcess)) {
            if (order.getId() == id) {
                return order;
            }
        }

        return null;
    }

    public Order getOrderById(long id) {

        for (Order order : getAllOrders()) {
            if (order.getId() == id) {
                return order;
            }
        }

        return null;
    }

    public List<Order> orderOrdersBy(String fieldName, List<Order> input) {
        RecordSorter<Order> recordSorter = new RecordSorter<>();
        recordSorter.orderRecordsBy(fieldName, input);
        return input;
    }

    public void shiftEndingDates(List<Order> neededToChangeOrders, long shiftedTime) {
        Date currentDate;
        Field oldValue;
        Field newValue;

        getAllOrders().removeAll(neededToChangeOrders);

        for (Order changeableOrder : neededToChangeOrders) {
            oldValue = changeableOrder.getFieldByName(Order.ENDING_DATE);
            currentDate = (Date) oldValue.getValue();

            newValue = new Field<>(Order.ENDING_DATE, new Date(currentDate.getTime() + shiftedTime));
            changeableOrder.setField(oldValue, newValue);

            changeableOrder.getFieldByName(Order.ENDING_DATE).setValue(new Date(currentDate.getTime() + shiftedTime));
        }

        getAllOrders().addAll(neededToChangeOrders);
        saveOrders();
    }
}
