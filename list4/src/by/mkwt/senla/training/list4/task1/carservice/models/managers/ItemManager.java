package by.mkwt.senla.training.list4.task1.carservice.models.managers;

public interface ItemManager<T> {

    void buildItemListFromFile();

    void addItem(T item);

    void removeItem(T item);

    void saveItemList();
}
