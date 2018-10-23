package by.mkwt.senla.training.list4.task1.carservice.utils;

import by.mkwt.senla.training.list4.task1.carservice.models.items.Item;

import java.util.ArrayList;

public class Printer {
    public static void print(ArrayList<Item> items) {
        for (Item item : items) {
            System.out.println(item.toLine());
        }
    }
}
