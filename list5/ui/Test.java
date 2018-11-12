package by.mkwt.senla.training.carservice.ui;

import by.mkwt.senla.training.carservice.loaders.PropertyLoader;
import by.mkwt.senla.training.carservice.logic.RequestMaster;

public class Test {
    public static void main(String[] args) {

        if (args == null || args.length == 0) {
            PropertyLoader.loadData("./resources/config.properties");
        } else {
            PropertyLoader.loadData(args[0]);
        }

        RequestMaster.getInstance();

        MenuController controller = new MenuController();

        controller.run();
    }
}
