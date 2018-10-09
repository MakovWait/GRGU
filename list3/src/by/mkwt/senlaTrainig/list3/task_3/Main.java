package by.mkwt.senlaTrainig.list3.task_3;

import by.mkwt.senlaTrainig.list3.task_3.flowers.Flower;
import by.mkwt.senlaTrainig.list3.task_3.flowers.products.Blowball;
import by.mkwt.senlaTrainig.list3.task_3.flowers.products.Rose;
import by.mkwt.senlaTrainig.list3.task_3.options.BouquetBuilder;

public class Main {
    /*
    Вариант 1
    */
    public static void main(String[] args) {
        BouquetBuilder bouquet = new BouquetBuilder();

        bouquet.buildCustomBouquet(new Flower[]{new Rose(), new Rose(), new Blowball()});
        System.out.print(bouquet.getCommonPrice());
    }
}
