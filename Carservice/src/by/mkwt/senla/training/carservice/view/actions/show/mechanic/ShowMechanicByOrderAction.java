package by.mkwt.senla.training.carservice.ui.actions.show.mechanic;

import by.mkwt.senla.training.carservice.api.CarService;
import by.mkwt.senla.training.ui.api.Action;
import by.mkwt.senla.training.ui.utils.ActionContentHolder;
import by.mkwt.senla.training.ui.utils.InputReader;

public class ShowMechanicByOrderAction implements Action {

    private final String INFO_MESSAGE = "Specify order id";
    private final String MESSAGE = "Mechanic with this order is\n";

    @Override
    public void execute() {
        long currentId = InputReader.getInstance().parseIntoId(InputReader.getInstance().listenInput(INFO_MESSAGE));
        ActionContentHolder.setContent(MESSAGE + CarService.getInstance().getRequestMaster().getMechanicsByOrderId(currentId));
    }
}
