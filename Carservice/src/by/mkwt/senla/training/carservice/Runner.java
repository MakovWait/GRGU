package by.mkwt.senla.training.carservice;

import by.mkwt.senla.training.carservice.api.CarService;
import by.mkwt.senla.training.carservice.view.Builder;
import by.mkwt.senla.training.ui.api.MenuController;

public class Runner {

    public static void main(String[] args) {
        CarService.getInstance();

        MenuController controller = new MenuController(new Builder());
        controller.run();
    }

}
