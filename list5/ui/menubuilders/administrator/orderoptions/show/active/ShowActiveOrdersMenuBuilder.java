package by.mkwt.senla.training.carservice.ui.menubuilders.administrator.orderoptions.show.active;

import by.mkwt.senla.training.carservice.ui.Menu;
import by.mkwt.senla.training.carservice.ui.MenuItem;
import by.mkwt.senla.training.carservice.ui.actions.show.order.active.ShowActiveOrderedByEndingDateOrdersAction;
import by.mkwt.senla.training.carservice.ui.actions.show.order.active.ShowActiveOrderedByFillingDateOrdersAction;
import by.mkwt.senla.training.carservice.ui.actions.show.order.active.ShowActiveOrderedByPriceOrdersAction;
import by.mkwt.senla.training.carservice.ui.actions.show.order.active.ShowActiveOrdersAction;
import by.mkwt.senla.training.carservice.ui.menubuilders.Builder;

public class ShowActiveOrdersMenuBuilder implements Builder {
    private Menu rootMenu;

    public ShowActiveOrdersMenuBuilder() {
        buildMenu();
    }

    @Override
    public void buildMenu() {
        rootMenu = new Menu("Active order options", new MenuItem[]{
                new MenuItem()
                        .setTitle("Show active orders without sort")
                        .setAction(new ShowActiveOrdersAction()),
                new MenuItem()
                        .setTitle("Show active orders ordered by filling date")
                        .setAction(new ShowActiveOrderedByFillingDateOrdersAction()),
                new MenuItem()
                        .setTitle("Show active orders ordered by ending date")
                        .setAction(new ShowActiveOrderedByEndingDateOrdersAction()),
                new MenuItem()
                        .setTitle("Show active orders ordered by price")
                        .setAction(new ShowActiveOrderedByPriceOrdersAction()),
        });
    }

    @Override
    public Menu getRootMenu() {
        return rootMenu;
    }
}
