package by.mkwt.senla.training.carservice.view.actions.show.garage;

import by.mkwt.senla.training.carservice.api.CarService;
import by.mkwt.senla.training.ui.api.Action;
import by.mkwt.senla.training.ui.utils.ActionContentHolder;

public class ShowNumOfFreeSpacesAction implements Action {

    private final String MESSAGE = "Num of free spaces : ";

    @Override
    public void execute() {
        ActionContentHolder.setContent(MESSAGE + CarService.getInstance().getRequestMaster().getNumOfFreeSpacesInCarService());
    }
}
