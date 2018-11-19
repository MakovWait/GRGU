package by.mkwt.senla.training.carservice.ui.menubuilders.administrator.orderoptions.show.all;

import by.mkwt.senla.training.carservice.ui.Menu;
import by.mkwt.senla.training.carservice.ui.MenuItem;
import by.mkwt.senla.training.carservice.ui.actions.show.order.all.*;
import by.mkwt.senla.training.carservice.ui.menubuilders.Builder;

public class ShowAllOrdersMenuBuilder implements Builder {
    private Menu rootMenu;

    public ShowAllOrdersMenuBuilder() {
        buildMenu();
    }

    @Override
    public void buildMenu() {
        rootMenu = new Menu("Order options", new MenuItem[]{
                new MenuItem()
                        .setTitle("Show all orders without sort")
                        .setAction(new ShowAllOrdersAction()),
                new MenuItem()
                        .setTitle("Show all orders ordered by starting date")
                        .setAction(new ShowAllOrderedByStartingDateOrdersAction()),
                new MenuItem()
                        .setTitle("Show all orders ordered by filling date")
                        .setAction(new ShowAllOrderedByFillingDateOrdersAction()),
                new MenuItem()
                        .setTitle("Show all orders ordered by ending date")
                        .setAction(new ShowAllOrderedByEndingDateOrdersAction()),
                new MenuItem()
                        .setTitle("Show all orders ordered by price")
                        .setAction(new ShowAllOrderedByPriceOrdersAction()),
        });
    }

    @Override
    public Menu getRootMenu() {
        return rootMenu;
    }
}
