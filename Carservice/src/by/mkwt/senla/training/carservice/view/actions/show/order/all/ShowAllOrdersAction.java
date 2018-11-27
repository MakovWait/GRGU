package by.mkwt.senla.training.carservice.ui.actions.show.order.all;

import by.mkwt.senla.training.carservice.api.CarService;
import by.mkwt.senla.training.ui.api.Action;
import by.mkwt.senla.training.ui.utils.ActionContentHolder;

public class ShowAllOrdersAction implements Action {

    private final String MESSAGE = "All orders: ";

    @Override
    public void execute() {
        ActionContentHolder.setContent(MESSAGE + CarService.getInstance().getRequestMaster().getAllOrders());
    }

}
