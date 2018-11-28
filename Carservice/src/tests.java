import by.mkwt.senla.training.carservice.logic.models.items.Order;
import by.mkwt.senla.training.carservice.logic.models.items.OrderState;

import java.math.BigDecimal;
import java.util.Date;

public class tests {
    public static void main(String[] args) throws CloneNotSupportedException {
        Order order = new Order(0L, new Date(0), new Date(0), new Date(0), new BigDecimal("2"), OrderState.inPlan);

        Order nOrder = (Order) order.clone();

        nOrder.setPrice(new BigDecimal("20"));
        System.out.println("Original" + order);
        System.out.println("****************************");
        System.out.println("Clone" + nOrder);
    }
}
