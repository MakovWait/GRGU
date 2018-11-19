package by.mkwt.senla.training.carservice.ui;

import by.mkwt.senla.training.carservice.logic.models.sorters.MechanicOrderableValues;
import by.mkwt.senla.training.carservice.logic.models.sorters.OrderOrderableValues;
import by.mkwt.senla.training.carservice.ui.actions.manage.garage.AddGarageAction;
import by.mkwt.senla.training.carservice.ui.actions.manage.garage.RemoveGarageAction;
import by.mkwt.senla.training.carservice.ui.actions.manage.mechanic.AddMechanicAction;
import by.mkwt.senla.training.carservice.ui.actions.manage.mechanic.RemoveMechanicAction;
import by.mkwt.senla.training.carservice.ui.actions.manage.order.AddOrderAction;
import by.mkwt.senla.training.carservice.ui.actions.manage.order.RemoveOrderAction;
import by.mkwt.senla.training.carservice.ui.actions.show.mechanic.ShowMechanicByOrderAction;
import by.mkwt.senla.training.carservice.ui.actions.show.mechanic.all.ShowAllMechanicsAction;
import by.mkwt.senla.training.carservice.ui.actions.show.mechanic.all.ShowAllOrderedByStateMechanicsAction;
import by.mkwt.senla.training.carservice.ui.actions.show.order.active.ShowActiveOrderedByStateOrdersAction;
import by.mkwt.senla.training.carservice.ui.actions.show.order.active.ShowActiveOrdersAction;
import by.mkwt.senla.training.carservice.ui.actions.show.order.all.ShowAllOrderedByStateOrdersAction;
import by.mkwt.senla.training.carservice.ui.actions.show.order.all.ShowAllOrdersAction;
import by.mkwt.senla.training.carservice.ui.actions.show.schedule.ShowNearestFreeDateAction;

public class Builder {

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

        manageGarageMenu = new Menu("Manage", new MenuItem[]{
                new MenuItem()
                        .setTitle("Add")
                        .setAction(new AddGarageAction()),
                new MenuItem()
                        .setTitle("Remove")
                        .setAction(new RemoveGarageAction())
        });

        showGarageMenu = new Menu("Show", new MenuItem[]{
                new MenuItem()
                        .setTitle("Show nearest free date")
                        .setAction(new ShowNearestFreeDateAction()),
        });

        garagesOptionsMenu = new Menu("Garage options", new MenuItem[]{
                new MenuItem()
                        .setTitle("Show")
                        .setNextMenu(showGarageMenu),
                new MenuItem()
                        .setTitle("Manage")
                        .setNextMenu(manageGarageMenu)
        });
    }

    private void buildMechanicsMenu() {
        Menu showMechanicMenu;
        Menu manageMechanicMenu;

        showMechanicMenu = new Menu("Show", new MenuItem[]{
                new MenuItem()
                        .setTitle("Show all mechanics without sort")
                        .setAction(new ShowAllMechanicsAction()),
                new MenuItem()
                        .setTitle("Show all mechanics ordered by name")
                        .setAction(new ShowAllOrderedByStateMechanicsAction(MechanicOrderableValues.byName)),
                new MenuItem()
                        .setTitle("Show all mechanics ordered by busyness")
                        .setAction(new ShowAllOrderedByStateMechanicsAction(MechanicOrderableValues.byBusyness)),
                new MenuItem()
                        .setTitle("Mechanic by order")
                        .setAction(new ShowMechanicByOrderAction())
        });

        manageMechanicMenu = new Menu("Manage", new MenuItem[]{
                new MenuItem()
                        .setTitle("Add")
                        .setAction(new AddMechanicAction()),
                new MenuItem()
                        .setTitle("Remove")
                        .setAction(new RemoveMechanicAction())
        });

        mechanicsOptionsMenu = new Menu("Mechanic options", new MenuItem[]{
                new MenuItem()
                        .setTitle("Show")
                        .setNextMenu(showMechanicMenu),
                new MenuItem()
                        .setTitle("Manage")
                        .setNextMenu(manageMechanicMenu)
        });
    }

    private void buildOrdersMenu() {
        Menu manageOrdersMenu;
        Menu showOrderMenu;
        Menu showActiveOrdersMenu;
        Menu showAllOrdersMenu;

        showAllOrdersMenu = new Menu("Order options", new MenuItem[]{
                new MenuItem()
                        .setTitle("Show all orders without sort")
                        .setAction(new ShowAllOrdersAction()),
                new MenuItem()
                        .setTitle("Show all orders ordered by starting date")
                        .setAction(new ShowAllOrderedByStateOrdersAction(OrderOrderableValues.byStartingDate)),
                new MenuItem()
                        .setTitle("Show all orders ordered by filling date")
                        .setAction(new ShowAllOrderedByStateOrdersAction(OrderOrderableValues.byFillingDate)),
                new MenuItem()
                        .setTitle("Show all orders ordered by ending date")
                        .setAction(new ShowAllOrderedByStateOrdersAction(OrderOrderableValues.byEndingDate)),
                new MenuItem()
                        .setTitle("Show all orders ordered by price")
                        .setAction(new ShowAllOrderedByStateOrdersAction(OrderOrderableValues.byPrice)),
        });

        showActiveOrdersMenu = new Menu("Active order options", new MenuItem[]{
                new MenuItem()
                        .setTitle("Show active orders without sort")
                        .setAction(new ShowActiveOrdersAction()),
                new MenuItem()
                        .setTitle("Show active orders ordered by filling date")
                        .setAction(new ShowActiveOrderedByStateOrdersAction(OrderOrderableValues.byFillingDate)),
                new MenuItem()
                        .setTitle("Show active orders ordered by ending date")
                        .setAction(new ShowActiveOrderedByStateOrdersAction(OrderOrderableValues.byEndingDate)),
                new MenuItem()
                        .setTitle("Show active orders ordered by price")
                        .setAction(new ShowActiveOrderedByStateOrdersAction(OrderOrderableValues.byPrice)),
        });

        showOrderMenu = new Menu("Show", new MenuItem[]{
                new MenuItem()
                        .setTitle("All orders")
                        .setNextMenu(showAllOrdersMenu),
                new MenuItem()
                        .setTitle("Active orders")
                        .setNextMenu(showActiveOrdersMenu)
        });

        manageOrdersMenu = new Menu("Manage", new MenuItem[]{
                new MenuItem()
                        .setTitle("Add")
                        .setAction(new AddOrderAction()),
                new MenuItem()
                        .setTitle("Remove")
                        .setAction(new RemoveOrderAction())
        });

        orderOptionsMenu = new Menu("Order options", new MenuItem[]{
                new MenuItem()
                        .setTitle("Show")
                        .setNextMenu(showOrderMenu),
                new MenuItem()
                        .setTitle("Manage")
                        .setNextMenu(manageOrdersMenu)
        });
    }

    private void buildRootMenu() {
        Menu userMenu;
        Menu administratorMenu;

        administratorMenu = new Menu("Options", new MenuItem[]{
                new MenuItem()
                        .setTitle("Orders options")
                        .setNextMenu(orderOptionsMenu),
                new MenuItem()
                        .setTitle("Mechanics options")
                        .setNextMenu(mechanicsOptionsMenu),
                new MenuItem()
                        .setTitle("Garages options")
                        .setNextMenu(garagesOptionsMenu)
        });

        userMenu = new Menu("User options", new MenuItem[]{
                new MenuItem()
                        .setTitle("Show nearest free date")
                        .setAction(new ShowNearestFreeDateAction()),
                new MenuItem()
                        .setTitle("Leave an order")
                        .setAction(new AddOrderAction())
        });

        rootMenu = new Menu("Car Service", new MenuItem[]{
                new MenuItem()
                        .setTitle("Leave an order")
                        .setNextMenu(userMenu),
                new MenuItem()
                        .setTitle("Op options")
                        .setNextMenu(administratorMenu)
        });
    }

    public Menu getRootMenu() {
        return rootMenu;
    }

}
