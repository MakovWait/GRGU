package by.mkwt.senla.training.carservice.ui.actions.show.order.active;

import by.mkwt.senla.training.carservice.api.CarService;
import by.mkwt.senla.training.carservice.logic.models.sorters.OrderOrderableValues;
import by.mkwt.senla.training.carservice.ui.actions.Action;

public class ShowActiveOrderedByStateOrdersAction implements Action{

    private final String MESSAGE = "Active orders ordered ";
    private OrderOrderableValues value;

    public ShowActiveOrderedByStateOrdersAction(OrderOrderableValues value) {
        this.value = value;
    }

    @Override
    public void execute() {
        System.out.println(MESSAGE + value + CarService.getInstance().getRequestMaster().getActiveOrdersOrderedBy(value));
    }
}
