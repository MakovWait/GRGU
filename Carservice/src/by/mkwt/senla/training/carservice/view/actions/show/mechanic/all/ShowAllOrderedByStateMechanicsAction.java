package by.mkwt.senla.training.carservice.view.actions.show.mechanic.all;

import by.mkwt.senla.training.carservice.api.CarService;
import by.mkwt.senla.training.carservice.logic.models.sorters.MechanicOrderableValues;
import by.mkwt.senla.training.ui.api.Action;
import by.mkwt.senla.training.ui.utils.ActionContentHolder;

public class ShowAllOrderedByStateMechanicsAction implements Action {

    private final String MESSAGE = "All mechanics ordered ";
    private MechanicOrderableValues value;

    public ShowAllOrderedByStateMechanicsAction(MechanicOrderableValues value) {
        this.value = value;
    }

    @Override
    public void execute() {
        ActionContentHolder.setContent(MESSAGE +  value + CarService.getInstance().getRequestMaster().getAllMechanicsOrderedBy(value));
    }
}
