package by.mkwt.senla.training.carservice.view.actions.show.mechanic.all;

import by.mkwt.senla.training.carservice.api.CarService;
import by.mkwt.senla.training.ui.api.Action;
import by.mkwt.senla.training.ui.utils.ActionContentHolder;

public class ShowAllMechanicsAction implements Action {

    private final String MESSAGE = "All mechanics ";


    @Override
    public void execute() {
        ActionContentHolder.setContent(MESSAGE + CarService.getInstance().getRequestMaster().getAllMechanics());
    }
}
