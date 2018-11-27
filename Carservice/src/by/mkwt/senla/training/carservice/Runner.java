package by.mkwt.senla.training.carservice;

import by.mkwt.senla.training.carservice.api.CarService;
import by.mkwt.senla.training.carservice.loaders.PropertyLoader;
import by.mkwt.senla.training.carservice.view.Builder;
import by.mkwt.senla.training.ui.api.MenuController;

public class Runner {

    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            CarService.load(new PropertyLoader("./resources/config.properties"));
        } else {
            CarService.load(new PropertyLoader(args[0]));
        }

        MenuController controller = new MenuController(new Builder());
        controller.run();
    }

}
