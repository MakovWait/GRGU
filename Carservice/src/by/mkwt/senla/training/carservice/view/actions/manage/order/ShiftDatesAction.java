package by.mkwt.senla.training.carservice.ui.actions.manage.order;

import by.mkwt.senla.training.carservice.api.CarService;
import by.mkwt.senla.training.ui.api.Action;
import by.mkwt.senla.training.ui.utils.ActionContentHolder;
import by.mkwt.senla.training.ui.utils.InputReader;

public class ShiftDatesAction implements Action {

    private final String INFO_MESSAGE = "Specify order id ";

    @Override
    public void execute() {
        long currentId = InputReader.getInstance().parseIntoId(InputReader.getInstance().listenInput(INFO_MESSAGE));
        CarService.getInstance().getRequestMaster().setDelayedOrder(currentId);
        ActionContentHolder.setContent("Success");
    }
}
