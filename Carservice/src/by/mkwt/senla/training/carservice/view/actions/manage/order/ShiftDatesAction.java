package by.mkwt.senla.training.carservice.view.actions.manage.order;

import by.mkwt.loaders.PermissionException;
import by.mkwt.senla.training.carservice.api.CarService;
import by.mkwt.senla.training.carservice.view.Constants;
import by.mkwt.senla.training.ui.api.Action;
import by.mkwt.senla.training.ui.utils.ActionContentHolder;
import by.mkwt.senla.training.ui.utils.InputReader;

public class ShiftDatesAction implements Action {

    private final String INFO_MESSAGE = "Specify order id ";

    @Override
    public void execute() {
        long currentId = InputReader.getInstance().parseIntoId(InputReader.getInstance().listenInput(INFO_MESSAGE));
        try {
            CarService.getInstance().getManageMaster().setDelayedOrder(currentId);
        } catch (PermissionException e) {
            e.printStackTrace();
            return;
        }
        ActionContentHolder.setContent(Constants.SUCCESS_MESSAGE);
    }
}
