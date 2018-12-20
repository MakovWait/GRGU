package by.mkwt.senla.training.carservice.api;

import by.mkwt.senla.training.carservice.logic.annotations.AnnotationConfigurator;
import by.mkwt.senla.training.carservice.logic.models.managers.GarageManager;
import by.mkwt.senla.training.carservice.logic.models.managers.MechanicManager;
import by.mkwt.senla.training.carservice.logic.models.managers.OrderManager;
import by.mkwt.senla.training.carservice.logic.models.managers.ScheduleManager;

import java.util.Stack;

public class CarService {

    private static CarService instance;

    private RequestMaster requestMaster;
    private ManageMaster manageMaster;

    private CarService() {
        loadComponents();
    }

    public static CarService getInstance() {
        if (instance == null) {
            instance = new CarService();
        }

        return instance;
    }

    private void loadComponents() {
        Stack<Object> configurationQueue = new Stack<>();

        ScheduleManager scheduleManager = new ScheduleManager();
        GarageManager garageManager = new GarageManager();
        MechanicManager mechanicManager = new MechanicManager();
        OrderManager orderManager = new OrderManager();

        requestMaster = new RequestMaster(scheduleManager, garageManager, orderManager, mechanicManager);

        manageMaster = new ManageMaster(scheduleManager, garageManager, orderManager, mechanicManager);

        configurationQueue.add(scheduleManager);
        configurationQueue.add(garageManager);
        configurationQueue.add(mechanicManager);
        configurationQueue.add(orderManager);
        configurationQueue.add(manageMaster);

        while (!configurationQueue.empty()) {
            AnnotationConfigurator.configure(configurationQueue.pop());
        }
    }

    public ManageMaster getManageMaster() {
        return manageMaster;
    }

    public RequestMaster getRequestMaster() {
        return requestMaster;
    }
}
