package by.mkwt.senla.training.carservice.view.actions.show.order;

import by.mkwt.senla.training.carservice.api.CarService;
import by.mkwt.senla.training.carservice.logic.models.items.OrderState;
import by.mkwt.senla.training.ui.api.Action;
import by.mkwt.senla.training.ui.utils.ActionContentHolder;
import by.mkwt.senla.training.ui.utils.InputReader;

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
            ActionContentHolder.setContent(CarService.getInstance().getRequestMaster().getOrdersInPeriod(state, fDate, sDate).toString());
        } catch (ParseException e) {
            ActionContentHolder.setContent(e.getMessage());
            return;
        }

        ActionContentHolder.setContent("success");
    }
}
