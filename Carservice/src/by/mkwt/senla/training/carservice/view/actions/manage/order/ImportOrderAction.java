package by.mkwt.senla.training.carservice.view.actions.manage.order;

import by.mkwt.senla.training.carservice.api.CarService;
import by.mkwt.senla.training.carservice.view.Constants;
import by.mkwt.senla.training.ui.api.Action;
import by.mkwt.senla.training.ui.utils.ActionContentHolder;

import java.io.FileNotFoundException;

public class ImportOrderAction implements Action{

    @Override
    public void execute() {
        try {
            CarService.getInstance().getManageMaster().importOrdersFromCsv();
        } catch (FileNotFoundException e) {
            ActionContentHolder.setContent(e.getMessage());
        }

        ActionContentHolder.setContent(Constants.SUCCESS_MESSAGE);
    }
}
