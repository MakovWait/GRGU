package by.mkwt.senla.training.carservice.view.actions.manage.order;

import by.mkwt.senla.training.carservice.api.CarService;
import by.mkwt.senla.training.ui.api.Action;
import by.mkwt.senla.training.ui.utils.ActionContentHolder;

public class ShowCopyBufferAction implements Action {
    @Override
    public void execute() {
        ActionContentHolder.setContent(CarService.getInstance().getManageMaster().getTmpCpyOrders().toString());
    }
}
