package by.mkwt.senla.training.carservice.ui.actions.show.order.byperiod;

import by.mkwt.senla.training.carservice.api.CarService;
import by.mkwt.senla.training.carservice.ui.actions.Action;
import by.mkwt.senla.training.carservice.ui.utils.InputReader;

public class ShowActiveOrderByMechanicAction implements Action {

    private final String INFO_MESSAGE = "Specify mechanic id";
    private final String MESSAGE = "Order with this mechanic is\n";

    @Override
    public void execute() {
        long currentId = InputReader.getInstance().parseIntoId(InputReader.getInstance().listenInput(INFO_MESSAGE));
        System.out.println(MESSAGE + CarService.getInstance().getRequestMaster().getOrderByMechanicId(currentId));
    }
}
