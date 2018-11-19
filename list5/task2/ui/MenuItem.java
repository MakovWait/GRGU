package by.mkwt.senla.training.carservice.ui;

import by.mkwt.senla.training.carservice.ui.actions.Action;

public class MenuItem {

    private String title;
    private Action action;

    private Menu nextMenu;

    public MenuItem() {
    }

    public void doAction() {
        action.execute();
    }

    public String getTitle() {
        return title;
    }

    public MenuItem setTitle(String title) {
        this.title = title;

        return this;
    }

    public Action getAction() {
        return action;
    }

    public MenuItem setAction(Action action) {
        this.action = action;

        return this;
    }

    public Menu getNextMenu() {
        return nextMenu;
    }

    public MenuItem setNextMenu(Menu nextMenu) {
        this.nextMenu = nextMenu;

        return this;
    }
}
