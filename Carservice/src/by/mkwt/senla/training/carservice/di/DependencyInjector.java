package by.mkwt.senla.training.carservice.di;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class DependencyInjector {

    private static DependencyInjector instance;

    private HashMap<String, String> test;

    private DependencyInjector() {
        test = new HashMap<>();

        test.put("by.mkwt.senla.training.carservice.api.managers.GarageManager", "by.mkwt.senla.training.carservice.logic.models.managers.GarageManager");
    }

    public static DependencyInjector getInstance() {
        if (instance == null) {
            instance = new DependencyInjector();
        }
        return instance;
    }


    public Object getClassInstance(Class<?> clazz) {

        Object result = null;

        try {
            result = Class.forName(test.get(clazz.getName())).getConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }

}
