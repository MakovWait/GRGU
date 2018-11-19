package by.mkwt.senla.training.carservice.ui.actions.manage.order;

import by.mkwt.senla.training.carservice.api.CarService;
import by.mkwt.senla.training.carservice.logic.exceptions.IllegalIdException;
import by.mkwt.senla.training.carservice.ui.actions.Action;
import by.mkwt.senla.training.carservice.ui.utils.InputReader;

public class CancelOrderAction implements Action {

    private final String INFO_MESSAGE = "Specify order id ";

    @Override
    public void execute() {
        long currentId = InputReader.getInstance().parseIntoId(InputReader.getInstance().listenInput(INFO_MESSAGE));
        try {
            CarService.getInstance().getManageMaster().cancelOrder(currentId);
        } catch (IllegalIdException e) {
            e.printStackTrace();
        }
    }
}
