package by.mkwt.senla.training.carservice.ui.actions.show.order.all;

import by.mkwt.senla.training.carservice.api.CarService;
import by.mkwt.senla.training.carservice.ui.actions.Action;

public class ShowAllOrdersAction implements Action {

    private final String MESSAGE = "All orders: ";

    @Override
    public void execute() {
        System.out.println(MESSAGE + CarService.getInstance().getRequestMaster().getAllOrders());
    }

}
