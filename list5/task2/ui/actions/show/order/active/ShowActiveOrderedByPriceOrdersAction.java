package by.mkwt.senla.training.carservice.ui.actions.show.order.active;

import by.mkwt.senla.training.carservice.logic.RequestMaster;
import by.mkwt.senla.training.carservice.sorters.OrderOrderableValues;
import by.mkwt.senla.training.carservice.ui.actions.Action;

public class ShowActiveOrderedByPriceOrdersAction implements Action{

    private final String MESSAGE = "Active orders ordered by price date ";

    @Override
    public void execute() {
        System.out.println(MESSAGE + RequestMaster.getInstance().getActiveOrdersOrderedBy(OrderOrderableValues.byPrice));
    }
}
