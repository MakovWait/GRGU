package by.mkwt.senla.training.carservice.logic;

import by.mkwt.senla.training.carservice.logic.exceptions.IllegalIdException;
import by.mkwt.senla.training.carservice.logic.exceptions.ItemIsAlreadyExistException;
import by.mkwt.senla.training.carservice.logic.exceptions.NoSuchItemException;
import by.mkwt.senla.training.carservice.logic.models.items.*;
import by.mkwt.senla.training.carservice.logic.models.managers.GarageManager;
import by.mkwt.senla.training.carservice.logic.models.managers.MechanicManager;
import by.mkwt.senla.training.carservice.logic.models.managers.OrderManager;
import by.mkwt.senla.training.carservice.logic.models.managers.ScheduleManager;

public class ManageMaster {

    private ScheduleManager scheduleManager;
    private GarageManager garageManager;
    private OrderManager orderManager;
    private MechanicManager mechanicManager;

    public ManageMaster(ScheduleManager scheduleManager,
                        GarageManager garageManager,
                        OrderManager orderManager,
                        MechanicManager mechanicManager) {

        this.scheduleManager = scheduleManager;
        this.garageManager = garageManager;
        this.orderManager = orderManager;
        this.mechanicManager = mechanicManager;
    }

    public Garage getGarageById(Long id) throws IllegalIdException {
        Garage result = garageManager.getGarageById(id);

        if (result == null) {
            throw new IllegalIdException();
        }

        return result;
    }

    public void addGarage(String garageStringImpl) throws IllegalIdException, ItemIsAlreadyExistException {
        garageManager.addGarage(garageManager.getGarageFromLine(garageStringImpl));
    }

    public void removeGarage(Long id) throws NoSuchItemException {
        garageManager.removeGarageById(id);
    }

    public void addMechanic(String mechanicStringImpl) throws IllegalIdException, ItemIsAlreadyExistException {
        mechanicManager.addMechanic(mechanicManager.getMechanicFromLine(mechanicStringImpl));
    }

    public void removeMechanic(Long id) throws NoSuchItemException {
        mechanicManager.removeMechanicById(id);
    }

    public Mechanic getMechanicById(Long id) throws IllegalIdException {
        Mechanic result = mechanicManager.getMechanicById(id);

        if (result == null) {
            throw new IllegalIdException();
        }

        return result;
    }

    public void addScheduleItem(String scheduleITemStringImpl) throws IllegalIdException, ItemIsAlreadyExistException {
        scheduleManager.addScheduleItem(scheduleManager.getGarageFromLine(scheduleITemStringImpl));
    }

    public void addOrder(String orderStringImpl) throws IllegalIdException, ItemIsAlreadyExistException {
        orderManager.addOrder(orderManager.getOrderFromLine(orderStringImpl));
    }

    public void removeOrder(Long id) throws NoSuchItemException {
        orderManager.removeOrderById(id);
    }

    public void closeOrder(Long id) throws IllegalIdException {
        orderManager.changeOrderStateById(id, OrderState.Closed);
    }

    public void cancelOrder(Long id) throws IllegalIdException {

        orderManager.changeOrderStateById(id, OrderState.Canceled);
    }

    public Order getOrderById(Long id) throws IllegalIdException {

        Order result = orderManager.getOrderById(id);

        if (result == null) {
            throw new IllegalIdException();
        }

        return result;
    }
}
