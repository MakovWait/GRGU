package task_3.options;

import task_3.flowers.Flower;

public class PriceCalculator {
    public static int getPrice(Flower[] bouqet){
        int price = 0;
        if (bouqet != null) {
            for (Flower f : bouqet) {
                price += f.getPrice();
            }
        }
        return price;
    }
}
