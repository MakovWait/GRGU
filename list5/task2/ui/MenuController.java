package by.mkwt.senla.training.carservice.ui;

import by.mkwt.senla.training.carservice.ui.utils.InputReader;

public class MenuController {

    private Builder builder;
    private Navigator navigator;

    public MenuController() {
        builder = new Builder();

        builder.buildMenu();
        navigator = new Navigator(builder.getRootMenu());
    }

    public void run() {
        int input;
        boolean exitFlag;

        do {
            navigator.printMenu();
            input = InputReader.getInstance().parseIntoNavigateInstruction(InputReader.getInstance().listenInput());
            exitFlag = navigator.navigate(input);
        } while (!exitFlag);

        InputReader.getInstance().dispose();
    }
}
