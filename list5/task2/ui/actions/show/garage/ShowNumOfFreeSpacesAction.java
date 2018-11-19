package by.mkwt.senla.training.carservice.ui.actions.show.garage;

import by.mkwt.senla.training.carservice.api.CarService;
import by.mkwt.senla.training.carservice.ui.actions.Action;

public class ShowNumOfFreeSpacesAction implements Action {

    private final String MESSAGE = "Num of free spaces : ";

    @Override
    public void execute() {
        System.out.println(MESSAGE + CarService.getInstance().getRequestMaster().getNumOfFreeSpacesInCarService());
    }
}
