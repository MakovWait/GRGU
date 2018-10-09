package by.mkwt.senlaTrainig.list3.task_3.options;


import by.mkwt.senlaTrainig.list3.task_3.flowers.Flower;

public class BouquetBuilder {
    Flower[] bouquet;

    public void buildCustomBouquet(Flower[] flowers) {
        this.bouquet = flowers;
    }

    public int getCommonPrice() {
        return PriceCalculator.getPrice(bouquet);
    }
}
