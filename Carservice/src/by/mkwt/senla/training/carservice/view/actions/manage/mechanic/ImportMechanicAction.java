package by.mkwt.senla.training.carservice.view.actions.manage.mechanic;

import by.mkwt.senla.training.carservice.api.CarService;
import by.mkwt.senla.training.carservice.view.Constants;
import by.mkwt.senla.training.ui.api.Action;
import by.mkwt.senla.training.ui.utils.ActionContentHolder;

import java.io.FileNotFoundException;

public class ImportMechanicAction implements Action{

    @Override
    public void execute() {
        try {
            CarService.getInstance().getManageMaster().importMechanicsFromCsv();
        } catch (FileNotFoundException e) {
            ActionContentHolder.setContent(e.getMessage());
            return;
        }

        ActionContentHolder.setContent(Constants.SUCCESS_MESSAGE);
    }
}
