package by.mkwt.senla.training.carservice.loaders;

import java.io.*;
import java.util.Collection;
import java.util.Objects;

public class LoaderComponent<T> {

    public static final String DELIMITER = "\\|";
    public static final String BORDER = "|";

    private ItemParser<T> itemParser;

    private String[] lines;
    private int counter = -1;

    private String pathToFile;

    private boolean isStart = false;

    private FileInputStream file;
    private ObjectInputStream fileIn;

    public LoaderComponent(ItemParser<T> itemParser, String pathToFile) {
        this.itemParser = Objects.requireNonNull(itemParser, "Item parser shouldn't be null");

        this.pathToFile = pathToFile;
    }

    public void start() {
        isStart = true;
        try {
            file = new FileInputStream(pathToFile);
            fileIn = new ObjectInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            file.close();
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public T getNextItem() {

        T result = null;

        try {
            result = (T) fileIn.readObject();
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }

    public T getItemFromLine(String line) {
        return itemParser.getItemFrom(line);
    }

    public void writeItemsToFile(Collection<T> items) {
        Objects.requireNonNull(items, "Writable items should be initialized first");

        try (FileOutputStream fileOut = new FileOutputStream(pathToFile); ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            for (T item : items) {
                out.writeObject(item);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
