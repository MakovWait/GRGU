package by.mkwt.senla.training.carservice.api;

import by.mkwt.senla.training.carservice.logic.annotations.AppConfig;
import by.mkwt.senla.training.carservice.logic.annotations.ConfigProperty;
import by.mkwt.senla.training.carservice.logic.annotations.PropertyType;
import by.mkwt.senla.training.carservice.logic.exceptions.*;
import by.mkwt.senla.training.carservice.logic.models.items.*;
import by.mkwt.senla.training.carservice.logic.models.managers.GarageManager;
import by.mkwt.senla.training.carservice.logic.models.managers.MechanicManager;
import by.mkwt.senla.training.carservice.logic.models.managers.OrderManager;
import by.mkwt.senla.training.carservice.logic.models.managers.ScheduleManager;

import java.io.FileNotFoundException;
import java.util.*;

@AppConfig
public class ManageMaster {

    private ScheduleManager scheduleManager;
    private GarageManager garageManager;
    private OrderManager orderManager;
    private MechanicManager mechanicManager;

    @ConfigProperty(propertyName = "op.garage_manage_permission", type = PropertyType.Boolean)
    private boolean garageManagePermission;
    @ConfigProperty(propertyName = "op.shift_dates_permission", type = PropertyType.Boolean)
    private boolean shiftDatesPermission;
    @ConfigProperty(propertyName = "op.delete_orders_permission", type = PropertyType.Boolean)
    private boolean deleteOrdersPermission;

    private List<Order> tmpCpyOrders;

    public ManageMaster(ScheduleManager scheduleManager,
                        GarageManager garageManager,
                        OrderManager orderManager,
                        MechanicManager mechanicManager) {

        this.scheduleManager = scheduleManager;
        this.garageManager = garageManager;
        this.orderManager = orderManager;
        this.mechanicManager = mechanicManager;

        tmpCpyOrders = new ArrayList<>();
    }

    public Garage getGarageById(Long id) throws IllegalIdException {
        Garage result = garageManager.getGarageById(id);

        if (result == null) {
            throw new IllegalIdException();
        }

        return result;
    }

    public void addGarage(String garageStringImpl) throws IllegalIdException, ItemIsAlreadyExistException, IllegalItemLineImplException, PermissionException {
        if (!garageManagePermission) {
            throw new PermissionException();
        }

        try {
            Garage tmp = garageManager.getGarageFromLine(garageStringImpl);
            garageManager.addGarage(tmp);
        } catch (NumberFormatException e) {
            throw new IllegalItemLineImplException();
        }
    }

    public void removeGarage(Long id) throws NoSuchItemException, PermissionException {
        if (!garageManagePermission) {
            throw new PermissionException();
        }

        garageManager.removeGarageById(id);
    }

    public void importGaragesFromCsv() throws FileNotFoundException {
        garageManager.importFromCsv();
    }

    public void exportGaragesToCsv() {
        garageManager.exportToCsv();
    }

    public void addMechanic(String mechanicStringImpl) throws IllegalIdException, ItemIsAlreadyExistException, IllegalItemLineImplException {
        try {
            Mechanic tmp = mechanicManager.getMechanicFromLine(mechanicStringImpl);
            mechanicManager.addMechanic(tmp);
        } catch (NumberFormatException e) {
            throw new IllegalItemLineImplException();
        }
    }

    public void removeMechanic(Long id) throws NoSuchItemException {
        mechanicManager.removeMechanicById(id);
    }

    public void importMechanicsFromCsv() throws FileNotFoundException {
        mechanicManager.importFromCsv();
    }

    public void exportMechanicsToCsv() {
        mechanicManager.exportToCsv();
    }

    public Mechanic getMechanicById(Long id) throws IllegalIdException {
        Mechanic result = mechanicManager.getMechanicById(id);

        if (result == null) {
            throw new IllegalIdException();
        }

        return result;
    }

    public void addScheduleItem(String scheduleITemStringImpl) throws IllegalIdException, ItemIsAlreadyExistException, IllegalItemLineImplException {
        try {
            ScheduleItem tmp = scheduleManager.getGarageFromLine(scheduleITemStringImpl);
            scheduleManager.addScheduleItem(tmp);
        } catch (NumberFormatException e) {
            throw new IllegalItemLineImplException();
        }
    }

    public void addOrder(String orderStringImpl) throws IllegalIdException, ItemIsAlreadyExistException, IllegalItemLineImplException {
        try {
            Order tmp = orderManager.getOrderFromLine(orderStringImpl);
            orderManager.addOrder(tmp);
        } catch (NumberFormatException e) {
            throw new IllegalItemLineImplException();
        }
    }

    public void modifyOrder(Order cpyOrder, String orderStringImpl) {
        Order newOrder = orderManager.getOrderFromLine(cpyOrder.getId().toString() +  "|" + orderStringImpl);
        orderManager.updateOrder(newOrder);
    }

    public void removeOrder(Long id) throws NoSuchItemException, PermissionException {
        if (!deleteOrdersPermission) {
            throw new PermissionException();
        }
        orderManager.removeOrderById(id);
    }

    public void importOrdersFromCsv() throws FileNotFoundException {
        orderManager.importFromCsv();
    }

    public void exportOrdersToCsv() {
        orderManager.exportToCsv();
    }

    public void closeOrder(Long id) throws IllegalIdException {
        orderManager.changeOrderStateById(id, OrderState.Closed);
    }

    public void cancelOrder(Long id) throws IllegalIdException {
        orderManager.changeOrderStateById(id, OrderState.Canceled);
    }

    public Order getOrderById(Long id) throws IllegalIdException {
        Order result = orderManager.getOrderById(id);

        if (result == null) {
            throw new IllegalIdException();
        }

        return result;
    }

    /**
     * Shift orders
     */
    public void setDelayedOrder(long orderId) throws PermissionException {
        if (!shiftDatesPermission) {
            throw new PermissionException();
        }

        long delayedTime = new Date().getTime() - orderManager.getOrderById(orderId).getEndingDate().getTime();
        List<Order> dependentOrders = getDependentOrders(orderId);
        shiftOrdersEndingDate(dependentOrders, delayedTime);
    }

    private void shiftOrdersEndingDate(List<Order> dependentOrders, long delayedTime) {
        List<Order> neededToChangeOrders = orderManager.getAllOrders();
        neededToChangeOrders.retainAll(dependentOrders);

        orderManager.shiftEndingDates(neededToChangeOrders, delayedTime);
    }

    private List<Order> getDependentOrders(long orderId) {
        HashSet<Order> result = new HashSet<>();
        HashSet<Long> mechanicsInOrder = new HashSet<>();
        HashSet<Long> garagesInOrder = new HashSet<>();

        for (ScheduleItem scheduleItem : scheduleManager.getSchedule()) {
            if (scheduleItem.getOrderId() == orderId) {
                mechanicsInOrder.add(scheduleItem.getMechanicId());
                garagesInOrder.add(scheduleItem.getGarageId());
            } else if (!mechanicsInOrder.add(scheduleItem.getMechanicId())
                    || !garagesInOrder.add(scheduleItem.getGarageId())) {

                result.add(orderManager.getOrderById(scheduleItem.getOrderId()));
            }
        }

        return new ArrayList<>(result);
    }

    public void copyOrder(long orderId) throws IllegalIdException, CloneNotSupportedException {
        Order currentOrder = orderManager.getOrderById(orderId);

        if (currentOrder == null) {
            throw new IllegalIdException();
        }

        tmpCpyOrders.add((Order) currentOrder.clone());
    }

    public Order getCpyOrderById(long id) throws IllegalIdException {
        Order result = orderManager.getOrderByIdInCustomArray(tmpCpyOrders, id);

        if (result == null) {
            throw new IllegalIdException();
        }

        return result;
    }

    public List<Order> getTmpCpyOrders() {
        return tmpCpyOrders;
    }
}
