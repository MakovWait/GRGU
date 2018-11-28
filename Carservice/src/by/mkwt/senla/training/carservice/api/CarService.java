package by.mkwt.senla.training.carservice.api;

import by.mkwt.loaders.PropertyLoader;
import by.mkwt.senla.training.carservice.logic.models.managers.GarageManager;
import by.mkwt.senla.training.carservice.logic.models.managers.MechanicManager;
import by.mkwt.senla.training.carservice.logic.models.managers.OrderManager;
import by.mkwt.senla.training.carservice.logic.models.managers.ScheduleManager;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.log4j.Logger;

import java.util.HashMap;

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
        ScheduleManager scheduleManager = new ScheduleManager(loader.getProperty("bin.path_to_schedule"));
        GarageManager garageManager = new GarageManager(loader.getProperty("bin.path_to_garage"));
        MechanicManager mechanicManager = new MechanicManager(loader.getProperty("bin.path_to_mechanics"));
        OrderManager orderManager = new OrderManager(loader.getProperty("bin.path_to_orders"));

        requestMaster = new RequestMaster(scheduleManager, garageManager, orderManager, mechanicManager);

        HashMap<String, Boolean> permissions = new HashMap<>();
        permissions.put("garage_manage_permission", Boolean.parseBoolean(loader.getProperty("garage_manage_permission")));
        permissions.put("shift_dates_permission", Boolean.parseBoolean(loader.getProperty("shift_dates_permission")));
        permissions.put("delete_orders_permission", Boolean.parseBoolean(loader.getProperty("delete_orders_permission")));

        manageMaster = new ManageMaster(scheduleManager, garageManager, orderManager, mechanicManager, permissions);
    }

    public ManageMaster getManageMaster() {
        return manageMaster;
    }

    public RequestMaster getRequestMaster() {
        return requestMaster;
    }
}
