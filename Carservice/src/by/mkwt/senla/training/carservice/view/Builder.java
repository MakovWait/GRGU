package by.mkwt.senla.training.carservice.view;

import by.mkwt.senla.training.carservice.logic.models.sorters.MechanicOrderableValues;
import by.mkwt.senla.training.carservice.logic.models.sorters.OrderOrderableValues;
import by.mkwt.senla.training.carservice.view.actions.manage.garage.AddGarageAction;
import by.mkwt.senla.training.carservice.view.actions.manage.garage.RemoveGarageAction;
import by.mkwt.senla.training.carservice.view.actions.manage.mechanic.AddMechanicAction;
import by.mkwt.senla.training.carservice.ui.actions.manage.mechanic.RemoveMechanicAction;
import by.mkwt.senla.training.carservice.view.actions.manage.order.AddOrderAction;
import by.mkwt.senla.training.carservice.ui.actions.manage.order.RemoveOrderAction;
import by.mkwt.senla.training.carservice.ui.actions.show.mechanic.ShowMechanicByOrderAction;
import by.mkwt.senla.training.carservice.ui.actions.show.mechanic.all.ShowAllMechanicsAction;
import by.mkwt.senla.training.carservice.ui.actions.show.mechanic.all.ShowAllOrderedByStateMechanicsAction;
import by.mkwt.senla.training.carservice.ui.actions.show.order.active.ShowActiveOrderedByStateOrdersAction;
import by.mkwt.senla.training.carservice.ui.actions.show.order.active.ShowActiveOrdersAction;
import by.mkwt.senla.training.carservice.ui.actions.show.order.all.ShowAllOrderedByStateOrdersAction;
import by.mkwt.senla.training.carservice.ui.actions.show.order.all.ShowAllOrdersAction;
import by.mkwt.senla.training.carservice.ui.actions.show.schedule.ShowNearestFreeDateAction;
import by.mkwt.senla.training.ui.api.MenuBuilder;
import by.mkwt.senla.training.ui.structure.Menu;
import by.mkwt.senla.training.ui.structure.MenuItem;

public class Builder implements MenuBuilder {

    private Menu rootMenu;

    private Menu orderOptionsMenu;

    private Menu mechanicsOptionsMenu;

    private Menu garagesOptionsMenu;

    public void buildMenu() {
        buildGaragesMenu();
        buildMechanicsMenu();
        buildOrdersMenu();
        buildRootMenu();
    }

    private void buildGaragesMenu() {
        Menu showGarageMenu;
        Menu manageGarageMenu;

        manageGarageMenu = new Menu("Manage")
                .addMenuItem(
                        new MenuItem("Add")
                                .setAction(new AddGarageAction())
                )
                .addMenuItem(
                        new MenuItem("Remove")
                                .setAction(new RemoveGarageAction())
                );

        showGarageMenu = new Menu("Show")
                .addMenuItem(
                        new MenuItem("Show nearest free date")
                                .setAction(new ShowNearestFreeDateAction())
                );

        garagesOptionsMenu = new Menu("Garage options")
                .addMenuItem(
                        new MenuItem("Show")
                                .setNextMenu(showGarageMenu)
                )
                .addMenuItem(
                        new MenuItem("Manage")
                                .setNextMenu(manageGarageMenu)
                );

    }

    private void buildMechanicsMenu() {
        Menu showMechanicMenu;
        Menu manageMechanicMenu;

        showMechanicMenu = new Menu("Show")
                .addMenuItem(
                        new MenuItem("Show all mechanics without sort").setAction(new ShowAllMechanicsAction())
                )
                .addMenuItem(
                        new MenuItem("Show all mechanics ordered by name")
                                .setAction(new ShowAllOrderedByStateMechanicsAction(MechanicOrderableValues.byName))
                )
                .addMenuItem(
                        new MenuItem("Show all mechanics ordered by busyness")
                                .setAction(new ShowAllOrderedByStateMechanicsAction(MechanicOrderableValues.byBusyness))
                )
                .addMenuItem(new MenuItem("Mechanic by order")
                        .setAction(new ShowMechanicByOrderAction())
                );


        manageMechanicMenu = new Menu("Manage")
                .addMenuItem(
                        new MenuItem("Add")
                                .setAction(new AddMechanicAction())
                )
                .addMenuItem(new MenuItem("Remove")
                        .setAction(new RemoveMechanicAction())
                );

        mechanicsOptionsMenu = new Menu("Mechanic options")
                .addMenuItem(
                        new MenuItem("Show")
                                .setNextMenu(showMechanicMenu)
                )
                .addMenuItem(
                        new MenuItem("Manage")
                                .setNextMenu(manageMechanicMenu)
                );
    }

    private void buildOrdersMenu() {
        Menu manageOrdersMenu;
        Menu showOrderMenu;
        Menu showActiveOrdersMenu;
        Menu showAllOrdersMenu;

        showAllOrdersMenu = new Menu("Order options")
                .addMenuItem(
                        new MenuItem("Show all orders without sort")
                                .setAction(new ShowAllOrdersAction())
                )
                .addMenuItem(
                        new MenuItem("Show all orders ordered by starting date")
                                .setAction(new ShowAllOrderedByStateOrdersAction(OrderOrderableValues.byStartingDate))
                )
                .addMenuItem(
                        new MenuItem("Show all orders ordered by filling date")
                                .setAction(new ShowAllOrderedByStateOrdersAction(OrderOrderableValues.byFillingDate))
                )
                .addMenuItem(
                        new MenuItem("Show all orders ordered by ending date")
                                .setAction(new ShowAllOrderedByStateOrdersAction(OrderOrderableValues.byEndingDate))
                )
                .addMenuItem(
                        new MenuItem("Show all orders ordered by price")
                                .setAction(new ShowAllOrderedByStateOrdersAction(OrderOrderableValues.byPrice))
                );

        showActiveOrdersMenu = new Menu("Active order options")
                .addMenuItem(
                        new MenuItem("Show active orders without sort")
                                .setAction(new ShowActiveOrdersAction())
                )
                .addMenuItem(
                        new MenuItem("Show active orders ordered by filling date")
                                .setAction(new ShowActiveOrderedByStateOrdersAction(OrderOrderableValues.byFillingDate))
                )
                .addMenuItem(
                        new MenuItem("Show active orders ordered by ending date")
                                .setAction(new ShowActiveOrderedByStateOrdersAction(OrderOrderableValues.byEndingDate))
                )
                .addMenuItem(
                        new MenuItem("Show active orders ordered by price")
                                .setAction(new ShowActiveOrderedByStateOrdersAction(OrderOrderableValues.byPrice))
                );


        showOrderMenu = new Menu("Show")
                .addMenuItem(
                        new MenuItem("All orders")
                                .setNextMenu(showAllOrdersMenu)
                ).addMenuItem(
                        new MenuItem("Active orders")
                                .setNextMenu(showActiveOrdersMenu)
                );

        manageOrdersMenu = new Menu("Manage")
                .addMenuItem(
                        new MenuItem("Add")
                                .setAction(new AddOrderAction())
                ).addMenuItem(
                        new MenuItem("Remove")
                                .setAction(new RemoveOrderAction())
                );

        orderOptionsMenu = new Menu("Order options")
                .addMenuItem(
                        new MenuItem("Show")
                                .setNextMenu(showOrderMenu)
                )
                .addMenuItem(
                        new MenuItem("Manage")
                                .setNextMenu(manageOrdersMenu)
                );
    }

    private void buildRootMenu() {
        Menu userMenu;
        Menu administratorMenu;

        administratorMenu = new Menu("Options")
                .addMenuItem(
                        new MenuItem("Orders options")
                                .setNextMenu(orderOptionsMenu)
                ).addMenuItem(
                        new MenuItem("Mechanics options")
                                .setNextMenu(mechanicsOptionsMenu)
                ).addMenuItem(
                        new MenuItem("Garages options")
                                .setNextMenu(garagesOptionsMenu)
                );

        userMenu = new Menu("User options")
                .addMenuItem(
                        new MenuItem("Show nearest free date")
                                .setAction(new ShowNearestFreeDateAction())
                )
                .addMenuItem(
                        new MenuItem("Leave an order")
                                .setAction(new AddOrderAction())
                );

        rootMenu = new Menu("Car Service")
                .addMenuItem(
                        new MenuItem("Leave an order")
                                .setNextMenu(userMenu)
                )
                .addMenuItem(
                        new MenuItem("Op options")
                                .setNextMenu(administratorMenu)
                );
    }

    public Menu getRootMenu() {
        return rootMenu;
    }

}
