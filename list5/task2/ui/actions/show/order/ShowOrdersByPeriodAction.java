package by.mkwt.senla.training.carservice.ui.actions.show.order;

import by.mkwt.senla.training.carservice.api.CarService;
import by.mkwt.senla.training.carservice.logic.models.items.OrderState;
import by.mkwt.senla.training.carservice.ui.actions.Action;
import by.mkwt.senla.training.carservice.ui.utils.InputReader;

import java.text.ParseException;
import java.util.Date;

public class ShowOrdersByPeriodAction implements Action {

    private OrderState state;

    public ShowOrdersByPeriodAction(OrderState state) {
        this.state = state;
    }

    @Override
    public void execute() {
        try {
            Date fDate = InputReader.getInstance().parseIntoDate(InputReader.getInstance().listenInput());
            Date sDate = InputReader.getInstance().parseIntoDate(InputReader.getInstance().listenInput());
            System.out.print(CarService.getInstance().getRequestMaster().getOrdersInPeriod(state, fDate, sDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
