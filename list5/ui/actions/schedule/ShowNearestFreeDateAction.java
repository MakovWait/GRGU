package by.mkwt.senla.training.carservice.ui.actions.schedule;

import by.mkwt.senla.training.carservice.logic.RequestMaster;
import by.mkwt.senla.training.carservice.ui.actions.Action;

public class ShowNearestFreeDateAction implements Action {

    private final String MESSAGE = "Nearest date is : ";

    @Override
    public void execute() {
        System.out.println(MESSAGE + RequestMaster.getInstance().getNearestFreeDate());
    }
}
