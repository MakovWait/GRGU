package by.mkwt.senla.training.carservice.ui.actions.manage.garage;

import by.mkwt.senla.training.carservice.api.CarService;
import by.mkwt.senla.training.carservice.logic.exceptions.NoSuchItemException;
import by.mkwt.senla.training.carservice.ui.actions.Action;
import by.mkwt.senla.training.carservice.ui.utils.InputReader;

public class RemoveGarageAction implements Action {

    private final String INFO_MESSAGE = "Specify garage id ";

    @Override
    public void execute() {
        long currentId = InputReader.getInstance().parseIntoId(InputReader.getInstance().listenInput(INFO_MESSAGE));
        try {
            CarService.getInstance().getManageMaster().removeGarage(currentId);
        } catch (NoSuchItemException e) {
            e.printStackTrace();
        }
    }
}
