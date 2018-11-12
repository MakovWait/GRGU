package by.mkwt.senla.training.carservice.ui;

import by.mkwt.senla.training.carservice.ui.menubuilders.Builder;
import by.mkwt.senla.training.carservice.ui.menubuilders.GeneralBuilder;

import java.util.Scanner;

public class MenuController {

    private Builder builder;
    private Navigator navigator;

    public MenuController() {
        builder = new GeneralBuilder();

        builder.buildMenu();
        navigator = new Navigator(builder.getRootMenu());
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int input;
        boolean exitFlag;

        do {
            navigator.printMenu();
            input = scanner.nextInt() - 1;
            exitFlag = navigator.navigate(input);
        } while (!exitFlag);
    }
}
