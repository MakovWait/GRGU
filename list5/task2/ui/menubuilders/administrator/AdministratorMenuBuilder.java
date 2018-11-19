package by.mkwt.senla.training.carservice.ui.menubuilders.administrator;

import by.mkwt.senla.training.carservice.ui.Menu;
import by.mkwt.senla.training.carservice.ui.MenuItem;
import by.mkwt.senla.training.carservice.ui.menubuilders.Builder;
import by.mkwt.senla.training.carservice.ui.menubuilders.administrator.orderoptions.OrderOptionsMenuBuilder;

public class AdministratorMenuBuilder implements Builder{

    private Menu rootMenu;

    public AdministratorMenuBuilder() {
        buildMenu();
    }

    @Override
    public void buildMenu() {

        rootMenu = new Menu("Options", new MenuItem[]{
                new MenuItem()
                        .setTitle("Orders options")
                        .setNextMenu(new OrderOptionsMenuBuilder().getRootMenu())
        });
    }

    @Override
    public Menu getRootMenu() {
        return rootMenu;
    }
}
