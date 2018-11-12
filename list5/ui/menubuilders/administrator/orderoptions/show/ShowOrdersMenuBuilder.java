package by.mkwt.senla.training.carservice.ui.menubuilders.administrator.orderoptions.show;

import by.mkwt.senla.training.carservice.ui.Menu;
import by.mkwt.senla.training.carservice.ui.MenuItem;
import by.mkwt.senla.training.carservice.ui.menubuilders.Builder;
import by.mkwt.senla.training.carservice.ui.menubuilders.administrator.orderoptions.show.active.ShowActiveOrdersMenuBuilder;
import by.mkwt.senla.training.carservice.ui.menubuilders.administrator.orderoptions.show.all.ShowAllOrdersMenuBuilder;

public class ShowOrdersMenuBuilder implements Builder {

    private Menu rootMenu;

    public ShowOrdersMenuBuilder() {
        buildMenu();
    }

    @Override
    public void buildMenu() {
        rootMenu = new Menu("Show", new MenuItem[]{
                new MenuItem()
                        .setTitle("All orders")
                        .setNextMenu(new ShowAllOrdersMenuBuilder().getRootMenu()),
                new MenuItem()
                        .setTitle("Active orders")
                        .setNextMenu(new ShowActiveOrdersMenuBuilder().getRootMenu())
        });
    }

    @Override
    public Menu getRootMenu() {
        return rootMenu;
    }
}
