package by.mkwt.senla.training.carservice.view.actions.show.schedule;

import by.mkwt.senla.training.carservice.api.CarService;
import by.mkwt.senla.training.ui.api.Action;
import by.mkwt.senla.training.ui.utils.ActionContentHolder;

public class ShowNearestFreeDateAction implements Action {

    private final String MESSAGE = "Nearest date is : ";

    @Override
    public void execute() {
        ActionContentHolder.setContent(MESSAGE + CarService.getInstance().getRequestMaster().getNearestFreeDate());
    }
}
