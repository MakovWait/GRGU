package by.mkwt.senla.training.carservice.view.actions.show.order.byperiod;

import by.mkwt.senla.training.carservice.api.CarService;
import by.mkwt.senla.training.carservice.logic.models.items.OrderState;
import by.mkwt.senla.training.carservice.logic.models.sorters.OrderOrderableValues;
import by.mkwt.senla.training.ui.api.Action;
import by.mkwt.senla.training.ui.utils.ActionContentHolder;
import by.mkwt.senla.training.ui.utils.InputReader;

import java.text.ParseException;
import java.util.Date;

public class ShowOrdedByStateOrdersByPeriodAction implements Action {

    private OrderState state;
    private OrderOrderableValues value;

    public ShowOrdedByStateOrdersByPeriodAction(OrderState state, OrderOrderableValues value) {
        this.state = state;
        this.value = value;
    }

    @Override
    public void execute() {
        try {
            Date fDate = InputReader.getInstance().parseIntoDate(InputReader.getInstance().listenInput());
            Date sDate = InputReader.getInstance().parseIntoDate(InputReader.getInstance().listenInput());
            ActionContentHolder.setContent(CarService.getInstance().getRequestMaster().getOrdersInPeriodOrderedBy(state, fDate, sDate, value).toString());
        } catch (ParseException e) {
            ActionContentHolder.setContent(e.getMessage());
            return;
        }

        ActionContentHolder.setContent("success");
    }
}
