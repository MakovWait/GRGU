package by.mkwt.senla.training.carservice.ui.actions.show.order.all;

import by.mkwt.senla.training.carservice.api.CarService;
import by.mkwt.senla.training.carservice.logic.models.sorters.OrderOrderableValues;
import by.mkwt.senla.training.carservice.ui.actions.Action;

public class ShowAllOrderedByStateOrdersAction implements Action{

    private OrderOrderableValues value;
    private final String MESSAGE = "Orders ordered ";

    public ShowAllOrderedByStateOrdersAction(OrderOrderableValues value) {
        this.value = value;
    }

    @Override
    public void execute() {
        System.out.println(MESSAGE + value.toString() + CarService.getInstance().getRequestMaster().getAllOrdersOrderedBy(value));
    }
}
