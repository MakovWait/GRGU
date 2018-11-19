package by.mkwt.senla.training.carservice.ui;

import by.mkwt.senla.training.carservice.api.CarService;
import by.mkwt.senla.training.carservice.loaders.PropertyLoader;

public class Test {
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            CarService.load(new PropertyLoader("./resources/config.properties"));
        } else {
            CarService.load(new PropertyLoader(args[0]));
        }

        MenuController controller = new MenuController();
        controller.run();
    }
}
