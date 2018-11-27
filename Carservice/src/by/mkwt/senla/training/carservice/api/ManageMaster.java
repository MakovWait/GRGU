package by.mkwt.senla.training.carservice.api;

import by.mkwt.senla.training.carservice.logic.exceptions.IllegalIdException;
import by.mkwt.senla.training.carservice.logic.exceptions.IllegalItemLineImplException;
import by.mkwt.senla.training.carservice.logic.exceptions.ItemIsAlreadyExistException;
import by.mkwt.senla.training.carservice.logic.exceptions.NoSuchItemException;
import by.mkwt.senla.training.carservice.logic.models.items.*;
import by.mkwt.senla.training.carservice.logic.models.managers.GarageManager;
import by.mkwt.senla.training.carservice.logic.models.managers.MechanicManager;
import by.mkwt.senla.training.carservice.logic.models.managers.OrderManager;
import by.mkwt.senla.training.carservice.logic.models.managers.ScheduleManager;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;
import java.util.Objects;

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

    public void addGarage(String garageStringImpl) throws IllegalIdException, ItemIsAlreadyExistException, IllegalItemLineImplException {
        try {
            Garage tmp = garageManager.getGarageFromLine(garageStringImpl);
            garageManager.addGarage(tmp);
        } catch (NumberFormatException e) {
            throw new IllegalItemLineImplException();
        }
}

    public void removeGarage(Long id) throws NoSuchItemException {
        garageManager.removeGarageById(id);
    }

    public void addMechanic(String mechanicStringImpl) throws IllegalIdException, ItemIsAlreadyExistException, IllegalItemLineImplException {
        try {
            Mechanic tmp = mechanicManager.getMechanicFromLine(mechanicStringImpl);
            mechanicManager.addMechanic(tmp);
        } catch (NumberFormatException e) {
            throw new IllegalItemLineImplException();
        }
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

    public void addScheduleItem(String scheduleITemStringImpl) throws IllegalIdException, ItemIsAlreadyExistException, IllegalItemLineImplException {
        try {
            ScheduleItem tmp = scheduleManager.getGarageFromLine(scheduleITemStringImpl);
            scheduleManager.addScheduleItem(tmp);
        } catch (NumberFormatException e) {
            throw new IllegalItemLineImplException();
        }
    }

    public void addOrder(String orderStringImpl) throws IllegalIdException, ItemIsAlreadyExistException, IllegalItemLineImplException {
        try {
            Order tmp = orderManager.getOrderFromLine(orderStringImpl);
            orderManager.addOrder(tmp);
        } catch (NumberFormatException e) {
            throw new IllegalItemLineImplException();
        }
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
