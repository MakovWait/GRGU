package by.mkwt.senla.training.carservice.ui.actions.show;

import by.mkwt.senla.training.carservice.api.CarService;
import by.mkwt.senla.training.carservice.loaders.PropertyLoader;
import by.mkwt.senla.training.carservice.ui.actions.Action;
import by.mkwt.senla.training.carservice.ui.actions.show.mechanic.ShowMechanicByOrderAction;

public class Test {
    public static void main(String[] args) {
        CarService.load(new PropertyLoader("./resources/config.properties"));
        Action action = new ShowMechanicByOrderAction();

        action.execute();
    }
}
