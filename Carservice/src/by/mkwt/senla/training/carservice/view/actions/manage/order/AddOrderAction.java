package by.mkwt.senla.training.carservice.view.actions.manage.order;

import by.mkwt.senla.training.carservice.api.CarService;
import by.mkwt.senla.training.carservice.logic.exceptions.IllegalIdException;
import by.mkwt.senla.training.carservice.logic.exceptions.IllegalItemLineImplException;
import by.mkwt.senla.training.carservice.logic.exceptions.ItemIsAlreadyExistException;
import by.mkwt.senla.training.carservice.view.Constants;
import by.mkwt.senla.training.ui.api.Action;
import by.mkwt.senla.training.ui.utils.ActionContentHolder;
import by.mkwt.senla.training.ui.utils.InputReader;

public class AddOrderAction implements Action {

    private final String INFO_MESSAGE = "Specify order description ";

    @Override
    public void execute() {
        try {
            CarService.getInstance().getManageMaster().addOrder(InputReader.getInstance().listenInput(INFO_MESSAGE));
        } catch (IllegalItemLineImplException | IllegalIdException | ItemIsAlreadyExistException e) {
            ActionContentHolder.setContent(e.getMessage());
            return;
        }

        ActionContentHolder.setContent(Constants.SUCCESS_MESSAGE);
    }
}
