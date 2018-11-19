package by.mkwt.senla.training.carservice.ui.menubuilders.administrator.orderoptions;

import by.mkwt.senla.training.carservice.ui.Menu;
import by.mkwt.senla.training.carservice.ui.MenuItem;
import by.mkwt.senla.training.carservice.ui.actions.show.order.all.*;
import by.mkwt.senla.training.carservice.ui.menubuilders.Builder;
import by.mkwt.senla.training.carservice.ui.menubuilders.administrator.orderoptions.show.ShowOrdersMenuBuilder;

public class OrderOptionsMenuBuilder implements Builder {

    private Menu rootMenu;

    public OrderOptionsMenuBuilder() {
        buildMenu();
    }

    @Override
    public void buildMenu() {
        rootMenu = new Menu("Order options", new MenuItem[]{
                new MenuItem()
                        .setTitle("Show")
                        .setNextMenu(new ShowOrdersMenuBuilder().getRootMenu())
        });
    }

    @Override
    public Menu getRootMenu() {
        return rootMenu;
    }
}
