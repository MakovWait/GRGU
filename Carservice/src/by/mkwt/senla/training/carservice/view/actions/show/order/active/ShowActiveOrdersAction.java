package by.mkwt.senla.training.carservice.ui.actions.show.order.active;

import by.mkwt.senla.training.carservice.api.CarService;
import by.mkwt.senla.training.ui.api.Action;
import by.mkwt.senla.training.ui.utils.ActionContentHolder;

public class ShowActiveOrdersAction implements Action {

    private final String MESSAGE = "Active orders: ";

    @Override
    public void execute() {
        ActionContentHolder.setContent(MESSAGE + CarService.getInstance().getRequestMaster().getActiveOrders());
    }

}
