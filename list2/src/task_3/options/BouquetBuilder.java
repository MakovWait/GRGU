package task_3.options;

import task_3.flowers.Flower;

public class BouquetBuilder {
    Flower[] bouquet;

    public void buildCustomBouquet(Flower[] flowers){
        this.bouquet = flowers;
    }

    public int getCommonPrice(){
        return PriceCalculator.getPrice(bouquet);
    }
}
