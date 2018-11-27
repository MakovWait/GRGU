package by.mkwt.senla.training.carservice.api;


import by.mkwt.senla.training.carservice.logic.models.items.*;
import by.mkwt.senla.training.carservice.logic.models.managers.GarageManager;
import by.mkwt.senla.training.carservice.logic.models.managers.MechanicManager;
import by.mkwt.senla.training.carservice.logic.models.managers.OrderManager;
import by.mkwt.senla.training.carservice.logic.models.managers.ScheduleManager;
import by.mkwt.senla.training.carservice.logic.models.sorters.MechanicOrderableValues;
import by.mkwt.senla.training.carservice.logic.models.sorters.OrderOrderableValues;

import java.util.*;

public class RequestMaster {

    private ScheduleManager scheduleManager;
    private GarageManager garageManager;
    private OrderManager orderManager;
    private MechanicManager mechanicManager;

    public RequestMaster(ScheduleManager scheduleManager,
                         GarageManager garageManager,
                         OrderManager orderManager,
                         MechanicManager mechanicManager) {

        this.scheduleManager = scheduleManager;
        this.garageManager = garageManager;
        this.orderManager = orderManager;
        this.mechanicManager = mechanicManager;
    }

    /**
     * the list of empty garages in car service
     */
    public List<Garage> getEmptyGarages() {
        List<Garage> result = new ArrayList<>(garageManager.getAllGarages());

        for (ScheduleItem scheduleItem : scheduleManager.getSchedule()) {
            if (orderManager.getOrderById(scheduleItem.getOrderId()).getState()
                    .equals(OrderState.inProcess)
                    || orderManager.getOrderById(scheduleItem.getOrderId()).getState()
                    .equals(OrderState.inPlan)) {

                result.remove(garageManager.getGarageById(scheduleItem.getGarageId()));
            }
        }
        return result;
    }

    /**
     * the list of all orders in car service with sorts methods
     */
    public List<Order> getAllOrders() {
        return orderManager.getAllOrders();
    }

    public List<Order> getAllOrdersOrderedBy(OrderOrderableValues orderableValue) {
        return orderManager.orderBy(orderableValue);
    }

    /**
     * the list of all mechanics in car service with sorts methods
     */
    public List<Mechanic> getAllMechanics() {
        return mechanicManager.getAllMechanics();
    }

    public List<Mechanic> getAllMechanicsOrderedBy(MechanicOrderableValues orderableValue) {
        return mechanicManager.orderBy(orderableValue);
    }

    public List<Mechanic> getAllMechanicsOrderedByBusyness() {
        List<Mechanic> busyMechanics = new ArrayList<>();
        List<Mechanic> result = new ArrayList<>();

        OrderState tmpOrderState;
        for (ScheduleItem scheduleItem : scheduleManager.getSchedule()) {
            tmpOrderState = orderManager.getOrderById(scheduleItem.getOrderId()).getState();
            if (tmpOrderState.equals(OrderState.inProcess)
                    || tmpOrderState.equals(OrderState.inPlan)) {

                busyMechanics.add(mechanicManager.getMechanicById(scheduleItem.getMechanicId()));
            }
        }

        int frequency;

        for (Mechanic mechanic : mechanicManager.getAllMechanics()) {
            frequency = Collections.frequency(busyMechanics, mechanic);
            mechanic.setBusyness(frequency);
            result.add(mechanic);
        }

        mechanicManager.orderBy(MechanicOrderableValues.byBusyness);
        return result;
    }

    /**
     * the list of active orders in car service with sorts methods
     */

    public List<Order> getActiveOrders() {
        return orderManager.getAllOrdersBy(OrderState.inProcess);
    }

    public List<Order> getActiveOrdersOrderedBy(OrderOrderableValues orderableValue) {
        List<Order> result = orderManager.orderBy(orderableValue);
        result.retainAll(orderManager.getAllOrdersBy(OrderState.inProcess));

        return result;
    }


    /**
     * the mechanics list by order id
     */
    public List<Mechanic> getMechanicsByOrderId(long orderId) {
        List<Mechanic> result = new ArrayList<>();

        for (ScheduleItem scheduleItem : scheduleManager.getSchedule()) {
            if (scheduleItem.getOrderId() == orderId) {
                result.add(mechanicManager.getMechanicById(scheduleItem.getMechanicId()));
            }
        }

        return result;
    }

    /**
     * the order by mechanic id
     */
    public Order getOrderByMechanicId(long mechanicId) {

        for (ScheduleItem scheduleItem : scheduleManager.getSchedule()) {
            if (scheduleItem.getMechanicId() == mechanicId) {
                if (orderManager.getOrderById(scheduleItem.getOrderId()).getState().equals(OrderState.inProcess)) {
                    return orderManager.getOrderById(scheduleItem.getOrderId());
                }
            }
        }

        return null;
    }

    /*
     *   the orders in current period
     * */

    public List<Order> getOrdersInPeriod(OrderState state, Date firstDate, Date secondDate) {

        List<Order> result = new ArrayList<>();

        for (Order order : orderManager.getAllOrdersBy(state)) {
            if (order.getEndingDate().after(firstDate) && order.getEndingDate().before(secondDate)) {
                result.add(order);
            }
        }
        return result;
    }

    public List<Order> getOrdersInPeriodOrderedBy(OrderState state,
                                                  Date firstDate, Date secondDate,
                                                  OrderOrderableValues orderableValue) {

        List<Order> result = getAllOrdersOrderedBy(orderableValue);
        result.retainAll(getOrdersInPeriod(state, firstDate, secondDate));

        return result;
    }

    /*
     * the number of free spaces in car service
     * */

    public long getNumOfFreeSpacesInCarService() {
        return getFreeMechanics().size() + getEmptyGarages().size();
    }

    public List<Mechanic> getFreeMechanics() {
        List<Mechanic> result = new ArrayList<>(mechanicManager.getAllMechanics());

        for (ScheduleItem scheduleItem : scheduleManager.getSchedule()) {
            if (orderManager.getOrderById(scheduleItem.getOrderId()).getState()
                    .equals(OrderState.inProcess)
                    || orderManager.getOrderById(scheduleItem.getOrderId()).getState()
                    .equals(OrderState.inPlan)) {

                result.remove(mechanicManager.getMechanicById(scheduleItem.getMechanicId()));
            }
        }
        return result;
    }

    /*
     * The nearest free date
     * */

    public Date getNearestFreeDate() {
        List<Order> activeOrders = orderManager.getAllOrdersBy(OrderState.inProcess);
        activeOrders.addAll(orderManager.getAllOrdersBy(OrderState.inPlan));

        for (Order order : activeOrders) {
            if (getEmptyGarages().size() > 0 && getFreeMechanics().size() > 0) {
                return order.getEndingDate();
            }
        }

        return new Date();
    }

    /**
     * Shift orders
     */
    public void setDelayedOrder(long orderId) {
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
}