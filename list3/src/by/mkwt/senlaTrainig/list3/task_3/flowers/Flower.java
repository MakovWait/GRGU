package task_3.flowers;

public abstract class Flower {
    private int price;
    private String color;

    public Flower(int price, String color){
        this.price = price;
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int newPrice){
        price = newPrice;
    }

    public String getColor() {
        return color;
    }
}
