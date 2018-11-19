package by.mkwt.senla.training.carservice.ui.menubuilders;

import by.mkwt.senla.training.carservice.ui.Menu;
import by.mkwt.senla.training.carservice.ui.MenuItem;
import by.mkwt.senla.training.carservice.ui.menubuilders.administrator.AdministratorMenuBuilder;
import by.mkwt.senla.training.carservice.ui.menubuilders.user.UserMenuBuilder;

public class GeneralBuilder implements Builder{

    private Menu rootMenu;

    public void buildMenu() {

        rootMenu = new Menu("Car Service", new MenuItem[]{
                new MenuItem()
                        .setTitle("Leave an order")
                        .setNextMenu(new UserMenuBuilder().getRootMenu()),
                new MenuItem()
                        .setTitle("Op options")
                        .setNextMenu(new AdministratorMenuBuilder().getRootMenu())
        });
    }

    public Menu getRootMenu() {
        return rootMenu;
    }

}
