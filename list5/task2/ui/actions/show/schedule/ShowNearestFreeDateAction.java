package by.mkwt.senla.training.carservice.ui.actions.show.schedule;

import by.mkwt.senla.training.carservice.api.CarService;
import by.mkwt.senla.training.carservice.ui.actions.Action;

public class ShowNearestFreeDateAction implements Action {

    private final String MESSAGE = "Nearest date is : ";

    @Override
    public void execute() {
        System.out.println(MESSAGE + CarService.getInstance().getRequestMaster().getNearestFreeDate());
    }
}
