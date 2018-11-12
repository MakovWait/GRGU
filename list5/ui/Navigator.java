package by.mkwt.senla.training.carservice.ui;

import java.util.Stack;

public class Navigator {

    private Stack<Menu> history;

    private final int RETURN = -1;
    private final String BORDER = "*********************";
    private final String NAVIGATION_INFO = "For return press '0'";

    public Navigator(Menu rootMenu) {
        this.history = new Stack<>();
        history.push(rootMenu);
    }

    public void printMenu() {
        System.out.println(BORDER);
        System.out.println(history.peek());
        System.out.println(NAVIGATION_INFO);
    }

    /**
     * @return return true if history is ended*/
    public boolean navigate(Integer index) {
        if (index == RETURN) {
            if (!history.empty()) {
                history.pop();
            }

            if (history.empty()) {
                return true;
            }
        }

        try {
            MenuItem currentItem = history.peek().getMenuItemByIndex(index);
            if (currentItem.getAction() != null) {
                currentItem.doAction();
            } else {
                history.push(currentItem.getNextMenu());
            }
        } catch (NullPointerException e) {
            System.out.println("No such options");

        }

        return false;
    }
}
