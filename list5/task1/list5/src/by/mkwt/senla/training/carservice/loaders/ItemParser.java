package by.mkwt.senla.training.carservice.loaders;

public interface ItemParser<T> {

    T getItemFrom(String line);

    String getLineFrom(T item);
}
