package by.mkwt.senla.training.carservice.ui.actions.show.order.all;

import by.mkwt.senla.training.carservice.logic.RequestMaster;
import by.mkwt.senla.training.carservice.sorters.OrderOrderableValues;
import by.mkwt.senla.training.carservice.ui.actions.Action;

public class ShowAllOrderedByFillingDateOrdersAction implements Action{

    private final String MESSAGE = "Orders ordered by filling date ";

    @Override
    public void execute() {
        System.out.println(MESSAGE + RequestMaster.getInstance().getAllOrdersOrderedBy(OrderOrderableValues.byFillingDate));
    }
}
