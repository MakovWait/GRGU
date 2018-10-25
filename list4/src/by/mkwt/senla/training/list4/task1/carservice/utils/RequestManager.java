package by.mkwt.senla.training.list4.task1.carservice.utils;

import by.mkwt.senla.training.list4.task1.carservice.models.managers.GarageManager;
import by.mkwt.senla.training.list4.task1.carservice.models.managers.MechanicManager;
import by.mkwt.senla.training.list4.task1.carservice.models.managers.OrderManager;
import by.mkwt.senla.training.list4.task1.carservice.models.managers.ScheduleManager;
import by.mkwt.senla.training.list4.task1.carservice.utils.sorters.MechanicSorter;
import by.mkwt.senla.training.list4.task1.carservice.utils.sorters.OrderSorter;
import by.mkwt.senla.training.list4.task1.carservice.utils.sorters.comparators.mechanic.MechanicCompareTypes;
import by.mkwt.senla.training.list4.task1.carservice.utils.sorters.comparators.order.OrderCompareTypes;
import by.mkwt.senla.training.list4.task1.carservice.models.items.Garage;
import by.mkwt.senla.training.list4.task1.carservice.models.items.Mechanic;
import by.mkwt.senla.training.list4.task1.carservice.models.items.Order;
import by.mkwt.senla.training.list4.task1.carservice.models.items.OrderState;
import by.mkwt.senla.training.list4.task1.carservice.models.items.Schedule;

import java.util.*;

public class RequestManager {

    private  GarageManager garageManager;
    private  OrderManager orderManager;
    private  ScheduleManager scheduleManager;
    private  MechanicManager mechanicManager;

    public RequestManager() {
        garageManager = new GarageManager();
        orderManager = new OrderManager();
        scheduleManager = new ScheduleManager();
        mechanicManager = new MechanicManager();
    }

    public List<Garage> getEmptyGarages() {
        garageManager.buildItemListFromFile();
        List<Garage> tmpResult = new ArrayList<>();

        scheduleManager.buildItemListFromFile();
        ArrayList<Order> activeOrders = getActiveOrders();

        for (Schedule schedule : scheduleManager.getSchedules()) {
            for (Order order : activeOrders) {
                if (schedule.getOrderId().equals(order.getId())) {
                    tmpResult.add(garageManager.getGarageByID(schedule.getMechanicId()));
                }
            }
        }
        garageManager.getGarages().removeAll(tmpResult);

        return garageManager.getGarages();
    }

    public ArrayList<Order> getActiveOrders() {
        ArrayList<Order> result = new ArrayList<>();
        orderManager.buildItemListFromFile();

        for (Order order : orderManager.getOrders()) {
            if (order.getState() == OrderState.inProcess) {
                result.add(order);
            }
        }
        return result;
    }

    public ArrayList<Order> getActiveOrdersSortedBy(OrderCompareTypes type) {
        OrderSorter orderSorter = new OrderSorter();

        ArrayList<Order> result = getActiveOrders();
        result.sort(orderSorter.orderBy(type));

        return result;
    }

    public List<Order> getOrderList() {
        orderManager.buildItemListFromFile();
        return orderManager.getOrders();
    }

    public List<Order> getOrderListSortedBy(OrderCompareTypes type) {
        OrderSorter orderSorter = new OrderSorter();

        orderManager.buildItemListFromFile();
        orderManager.getOrders().sort(orderSorter.orderBy(type));
        return orderManager.getOrders();
    }

    public List<Mechanic> getMechanicList() {
        mechanicManager.buildItemListFromFile();
        return mechanicManager.getMechanics();
    }

    public List<Mechanic> getMechanicListSortedBy(MechanicCompareTypes type) {
        MechanicSorter mechanicSorter = new MechanicSorter();

        mechanicManager.buildItemListFromFile();
        mechanicManager.getMechanics().sort(mechanicSorter.orderBy(type));
        return mechanicManager.getMechanics();
    }

    public Order getOrderByMechanic(Mechanic mechanic) {
        scheduleManager.buildItemListFromFile();
        orderManager.buildItemListFromFile();
        for (Schedule schedule : scheduleManager.getSchedules()) {
            if(schedule.getMechanicId().equals(mechanic.getId())) {
                return orderManager.getOrderById(schedule.getOrderId());
            }
        }
        return null;
    }

    public ArrayList<Mechanic> getMechanicsByOrder(Order order) {
        scheduleManager.buildItemListFromFile();
        mechanicManager.buildItemListFromFile();
        ArrayList<Mechanic> mechanics = new ArrayList<>();

        for (Schedule schedule : scheduleManager.getSchedules()) {
            if(schedule.getOrderId().equals(order.getId())) {
                mechanics.add(mechanicManager.getMechanicById(schedule.getMechanicId()));
            }
        }
        return mechanics;
    }

    public Date getNearestFreeDate() {
        scheduleManager.buildItemListFromFile();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(scheduleManager.getSchedules().get(scheduleManager.getSchedules().size() - 1).getDate());
        calendar.add(Calendar.DAY_OF_WEEK, 1);

        return calendar.getTime();
    }
}
