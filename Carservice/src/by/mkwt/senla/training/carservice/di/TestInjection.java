package by.mkwt.senla.training.carservice.di;

import by.mkwt.senla.training.carservice.api.managers.GarageManager;

import java.lang.reflect.Method;

public class TestInjection {
    public static void main(String[] args) {
        GarageManager o = (GarageManager) DependencyInjector.getInstance().getClassInstance(GarageManager.class);

        Class<?> c = o.getClass();

        for (Method m : c.getDeclaredMethods()) {
            System.out.println(m.getName());
        }
    }
}
