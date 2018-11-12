package by.mkwt.senla.training.carservice.ui.actions.show.order.active;

import by.mkwt.senla.training.carservice.logic.RequestMaster;
import by.mkwt.senla.training.carservice.ui.actions.Action;

public class ShowActiveOrdersAction implements Action{

    private final String MESSAGE = "Active orders: ";

    @Override
    public void execute() {
        System.out.println(MESSAGE + RequestMaster.getInstance().getActiveOrders());
    }

}
