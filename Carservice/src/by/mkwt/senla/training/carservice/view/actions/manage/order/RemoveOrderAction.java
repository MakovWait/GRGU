package by.mkwt.senla.training.carservice.view.actions.manage.order;

import by.mkwt.senla.training.carservice.api.CarService;
import by.mkwt.senla.training.carservice.logic.exceptions.NoSuchItemException;
import by.mkwt.senla.training.carservice.logic.exceptions.PermissionException;
import by.mkwt.senla.training.carservice.view.Constants;
import by.mkwt.senla.training.ui.api.Action;
import by.mkwt.senla.training.ui.utils.ActionContentHolder;
import by.mkwt.senla.training.ui.utils.InputReader;

public class RemoveOrderAction implements Action {

    private final String INFO_MESSAGE = "Specify order id ";

    @Override
    public void execute() {
        long currentId = InputReader.getInstance().parseIntoId(InputReader.getInstance().listenInput(INFO_MESSAGE));
        try {
            CarService.getInstance().getManageMaster().removeOrder(currentId);
        } catch (NoSuchItemException e) {
            ActionContentHolder.setContent(e.getMessage());
            return;
        } catch (PermissionException e) {
            e.printStackTrace();
        }

        ActionContentHolder.setContent(Constants.SUCCESS_MESSAGE);
    }
}
