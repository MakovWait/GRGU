package by.mkwt.senla.training.carservice.ui.menubuilders.user;

import by.mkwt.senla.training.carservice.ui.Menu;
import by.mkwt.senla.training.carservice.ui.MenuItem;
import by.mkwt.senla.training.carservice.ui.actions.schedule.ShowNearestFreeDateAction;
import by.mkwt.senla.training.carservice.ui.menubuilders.Builder;

public class UserMenuBuilder implements Builder {

    private Menu rootMenu;

    public UserMenuBuilder() {
        buildMenu();
    }

    @Override
    public void buildMenu() {

        rootMenu = new Menu("User options", new MenuItem[]{
                new MenuItem()
                        .setTitle("Show nearest free date")
                        .setAction(new ShowNearestFreeDateAction()),
                new MenuItem()
                        .setTitle("Leave an order")
        });
    }

    @Override
    public Menu getRootMenu() {
        return rootMenu;
    }
}
