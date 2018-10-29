package by.mkwt.senla.training.list4.task1.carservice.logic;

import by.mkwt.senla.training.list4.task1.carservice.models.items.*;
import by.mkwt.senla.training.list4.task1.carservice.models.managers.GarageManager;
import by.mkwt.senla.training.list4.task1.carservice.models.managers.MechanicManager;
import by.mkwt.senla.training.list4.task1.carservice.models.managers.OrderManager;
import by.mkwt.senla.training.list4.task1.carservice.models.managers.ScheduleManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class RequestMaster {

    /**
     * the list of empty garages in car service
     */
    public List<Garage> getEmptyGarages() {
        ScheduleManager scheduleManager = new ScheduleManager();
        GarageManager garageManager = new GarageManager();
        OrderManager orderManager = new OrderManager();

        List<Garage> result = new ArrayList<>(garageManager.getAllGarages());

        for (ScheduleItem scheduleItem : scheduleManager.getSchedule()) {
            if (orderManager.getOrderById(scheduleItem.getOrderId()).getOrderState()
                    .equals(OrderState.inProcess)
                    || orderManager.getOrderById(scheduleItem.getOrderId()).getOrderState()
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
        OrderManager orderManager = new OrderManager();
        return orderManager.getAllOrders();
    }

    public List<Order> getAllOrdersOrderedBy(String orderableValue) {
        OrderManager orderManager = new OrderManager();
        orderManager.orderOrdersBy(orderableValue, orderManager.getAllOrders());
        return orderManager.getAllOrders();
    }

    /**
     * the list of all mechanics in car service with sorts methods
     */
    public List<Mechanic> getAllMechanics() {
        MechanicManager mechanicManager = new MechanicManager();
        return mechanicManager.getAllMechanics();
    }

    public List<Mechanic> getAllMechanicsOrderedBy(String orderableValue) {
        MechanicManager mechanicManager = new MechanicManager();
        mechanicManager.orderMechanicsBy(orderableValue, mechanicManager.getAllMechanics());
        return mechanicManager.getAllMechanics();
    }

    public List<Mechanic> getAllMechanicsOrderedByBusyness() {
        MechanicManager mechanicManager = new MechanicManager();
        OrderManager orderManager = new OrderManager();
        ScheduleManager scheduleManager = new ScheduleManager();

        List<Mechanic> busyMechanics = new ArrayList<>();
        List<Mechanic> result = new ArrayList<>();

        OrderState tmpOrderState;
        for (ScheduleItem scheduleItem : scheduleManager.getSchedule()) {
            tmpOrderState = orderManager.getOrderById(scheduleItem.getOrderId()).getOrderState();
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

        mechanicManager.orderMechanicsBy(Mechanic.BUSINESS, result);
        return result;
    }

    /**
     * the list of active orders in car service with sorts methods
     */
    public List<Order> getActiveOrders() {
        OrderManager orderManager = new OrderManager();
        return orderManager.getOrders(OrderState.inProcess);
    }

    public List<Order> getActiveOrdersOrderedBy(String orderableValue) {
        OrderManager orderManager = new OrderManager();

        List<Order> result = getActiveOrders();
        orderManager.orderOrdersBy(orderableValue, result);

        return result;
    }


    /**
     * the mechanics list by order id
     */
    public List<Mechanic> getMechanicsByOrderId(long orderId) {
        MechanicManager mechanicManager = new MechanicManager();
        ScheduleManager scheduleManager = new ScheduleManager();

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
        OrderManager orderManager = new OrderManager();
        ScheduleManager scheduleManager = new ScheduleManager();
        Order result = null;

        for (ScheduleItem scheduleItem : scheduleManager.getSchedule()) {
            if (scheduleItem.getMechanicId() == mechanicId) {
                result = orderManager.getActiveOrderById(scheduleItem.getOrderId());
                if (result != null) {
                    return result;
                }
            }
        }

        return result;
    }

    /*
     *   the orders in current period
     * */

    public List<Order> getOrdersInPeriod(OrderState state, Date firstDate, Date secondDate) {
        OrderManager orderManager = new OrderManager();

        List<Order> result = new ArrayList<>();

        for (Order order : orderManager.getOrders(state)) {
            if (order.getEndingDate().after(firstDate) && order.getEndingDate().before(secondDate)) {
                result.add(order);
            }
        }
        return result;
    }

    public List<Order> getOrdersInPeriodOrderedBy(OrderState state,
                                                  Date firstDate, Date secondDate,
                                                  String orderableValue) {
        OrderManager orderManager = new OrderManager();
        List<Order> result = getOrdersInPeriod(state, firstDate, secondDate);
        orderManager.orderOrdersBy(orderableValue, result);
        return result;
    }

    /*
     * the number of ree spaces in car service
     * */

    public long getNumOfFreeSpacesInCarService() {
        return getFreeMechanics().size() + getEmptyGarages().size();
    }

    public List<Mechanic> getFreeMechanics() {
        ScheduleManager scheduleManager = new ScheduleManager();
        MechanicManager mechanicManager = new MechanicManager();
        OrderManager orderManager = new OrderManager();

        List<Mechanic> result = new ArrayList<>(mechanicManager.getAllMechanics());

        for (ScheduleItem scheduleItem : scheduleManager.getSchedule()) {
            if (orderManager.getOrderById(scheduleItem.getOrderId()).getOrderState()
                    .equals(OrderState.inProcess)
                    || orderManager.getOrderById(scheduleItem.getOrderId()).getOrderState()
                    .equals(OrderState.inPlan)) {

                result.remove(mechanicManager.getMechanicById(scheduleItem.getMechanicId()));
            }
        }
        return result;
    }

    /*
     *   the nearest free date
     * */

    public Date getNearestFreeDate() {
        OrderManager orderManager = new OrderManager();

        List<Order> activeOrders = orderManager.getOrders(OrderState.inProcess);
        activeOrders.addAll(orderManager.getOrders(OrderState.inPlan));

        orderManager.orderOrdersBy(Order.ENDING_DATE, activeOrders);

        for (Order order : activeOrders) {
            if (getEmptyGarages().size() > 0 && getFreeMechanics().size() > 0) {
                return order.getEndingDate();
            }
        }

        return activeOrders.get(activeOrders.size() - 1).getEndingDate();
    }
}
