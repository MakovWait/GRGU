package by.mkwt.senla.training.carservice.view.actions.manage.order;

import by.mkwt.senla.training.carservice.api.CarService;
import by.mkwt.senla.training.carservice.logic.exceptions.IllegalIdException;
import by.mkwt.senla.training.carservice.logic.exceptions.IllegalItemLineImplException;
import by.mkwt.senla.training.carservice.logic.exceptions.ItemIsAlreadyExistException;
import by.mkwt.senla.training.carservice.logic.models.items.Order;
import by.mkwt.senla.training.carservice.view.Constants;
import by.mkwt.senla.training.ui.api.Action;
import by.mkwt.senla.training.ui.utils.ActionContentHolder;
import by.mkwt.senla.training.ui.utils.InputReader;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModifyOrderAction implements Action {

    @Override
    public void execute() {
        final String INFO_MESSAGE = "Cpy buffer: \n"
        + CarService.getInstance().getManageMaster().getTmpCpyOrders()
        + "\n Specify order id u want to modify";

        final String INFO_MESSAGE_FILLING_DATE = "\n Specify filling date";
        final String INFO_MESSAGE_STARTING_DATE = "\n Specify starting date";
        final String INFO_MESSAGE_ENDING_DATE = "\n Specify ending date";
        final String INFO_MESSAGE_PRICE = "\n Specify price ";
        final String INFO_MESSAGE_STATE = "\n Specify state ";

        long currentId = InputReader.getInstance().parseIntoId(InputReader.getInstance().listenInput(INFO_MESSAGE));

        Order cpyOrder;

        try {
            cpyOrder = CarService.getInstance().getManageMaster().getCpyOrderById(currentId);
        } catch (IllegalIdException e) {
            e.printStackTrace();
            ActionContentHolder.setContent(e.getMessage());
            return;
        }

        List<String> input = new ArrayList<>();

        input.add(InputReader.getInstance().listenInput(INFO_MESSAGE_FILLING_DATE));
        input.add(InputReader.getInstance().listenInput(INFO_MESSAGE_STARTING_DATE));
        input.add(InputReader.getInstance().listenInput(INFO_MESSAGE_ENDING_DATE));
        input.add(InputReader.getInstance().listenInput(INFO_MESSAGE_PRICE));
        input.add(InputReader.getInstance().listenInput(INFO_MESSAGE_STATE));

        CarService.getInstance().getManageMaster().modifyOrder(cpyOrder, String.join("|", input));

        ActionContentHolder.setContent(Constants.SUCCESS_MESSAGE);
    }
}
