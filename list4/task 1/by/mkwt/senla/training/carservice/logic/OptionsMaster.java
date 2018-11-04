package by.mkwt.senla.training.carservice.logic;

import by.mkwt.senla.training.carservice.models.items.Order;
import by.mkwt.senla.training.carservice.models.items.ScheduleItem;
import by.mkwt.senla.training.carservice.models.managers.OrderManager;
import by.mkwt.senla.training.carservice.models.managers.ScheduleManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class OptionsMaster {

    public void setDelayedOrder(long orderId, long delayedTime) {
        List<Order> dependentOrders = getDependentOrders(orderId);
        shiftOrdersEndingDate(dependentOrders, delayedTime);
    }

    private void shiftOrdersEndingDate(List<Order> dependentOrders, long delayedTime) {
        OrderManager orderManager = new OrderManager();

        List<Order> neededToChangeOrders = orderManager.getAllOrders();
        neededToChangeOrders.retainAll(dependentOrders);

        orderManager.shiftEndingDates(neededToChangeOrders, delayedTime);
    }

    private List<Order> getDependentOrders(long orderId) {
        ScheduleManager scheduleManager = new ScheduleManager();
        OrderManager orderManager = new OrderManager();

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
