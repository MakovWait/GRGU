package by.mkwt.senla.training.carservice.loaders;

import by.mkwt.senla.training.carservice.logic.exceptions.IllegalItemLineImplException;

public interface ItemParser<T> {

    T getItemFrom(String line);

    String[] getLineMassFrom(T item);

}
