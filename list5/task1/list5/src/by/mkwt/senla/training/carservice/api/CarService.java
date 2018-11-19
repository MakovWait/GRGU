package by.mkwt.senla.training.carservice.api;

import by.mkwt.senla.training.carservice.loaders.PropertyLoader;
import by.mkwt.senla.training.carservice.logic.ManageMaster;
import by.mkwt.senla.training.carservice.logic.RequestMaster;
import by.mkwt.senla.training.carservice.logic.models.managers.GarageManager;
import by.mkwt.senla.training.carservice.logic.models.managers.MechanicManager;
import by.mkwt.senla.training.carservice.logic.models.managers.OrderManager;
import by.mkwt.senla.training.carservice.logic.models.managers.ScheduleManager;
import org.apache.log4j.Logger;

public class CarService {

    private static Logger logger = Logger.getLogger(CarService.class);

    private static CarService instance;

    private RequestMaster requestMaster;
    private ManageMaster manageMaster;

    private CarService(PropertyLoader loader) {
        loadComponents(loader);
    }

    public static void load(PropertyLoader loader) {
        if (instance == null) {
            instance = new CarService(loader);
        }
    }

    public static CarService getInstance() {
        if (instance == null) {

            logger.error("Method CarService.load should be execute first");
            throw new IllegalStateException("Method CarService.load should be execute first");
        }

        return instance;
    }

    private void loadComponents(PropertyLoader loader) {
        ScheduleManager scheduleManager = new ScheduleManager(loader.getProperty("db.path_to_schedule"));
        GarageManager garageManager = new GarageManager(loader.getProperty("db.path_to_garage"));
        MechanicManager mechanicManager = new MechanicManager(loader.getProperty("db.path_to_mechanics"));
        OrderManager orderManager = new OrderManager(loader.getProperty("db.path_to_orders"));

        requestMaster = new RequestMaster(scheduleManager, garageManager, orderManager, mechanicManager);
        manageMaster = new ManageMaster(scheduleManager, garageManager, orderManager, mechanicManager);
    }

    public ManageMaster getManageMaster() {
        return manageMaster;
    }

    public RequestMaster getRequestMaster() {
        return requestMaster;
    }
}
