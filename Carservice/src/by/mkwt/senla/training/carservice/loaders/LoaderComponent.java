package by.mkwt.senla.training.carservice.loaders;

import javenue.csv.Csv;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class LoaderComponent<T> {

    public static final String DELIMITER = "\\|";
    private static final String BORDER = "|";

    private ItemParser<T> itemParser;

    private String pathToBinFile;
    private String pathToCsvFile;

    private FileInputStream file;
    private ObjectInputStream fileIn;

    public LoaderComponent(ItemParser<T> itemParser, String pathToBinFile, String pathToCsvFile) {
        this.itemParser = Objects.requireNonNull(itemParser, "Item parser shouldn't be null");

        this.pathToBinFile = pathToBinFile;
        this.pathToCsvFile = pathToCsvFile;
    }

    public void start() {
        try {
            file = new FileInputStream(pathToBinFile);
            fileIn = new ObjectInputStream(file);
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

        try (
                FileOutputStream fileOut = new FileOutputStream(pathToBinFile);
                ObjectOutputStream out = new ObjectOutputStream(fileOut)
        ) {
            for (T item : items) {
                out.writeObject(item);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<T> getItemsFromCsvFile() throws FileNotFoundException {
        List<T> result = new ArrayList<>();

        Csv.Reader reader = new Csv.Reader(new FileReader(pathToCsvFile)).delimiter(';');
        List<String> line;
        while ((line = reader.readLine()) != null) {
            result.add(itemParser.getItemFrom(String.join(BORDER, line)));
        }
        reader.close();

        return result;
    }

    public void writeItemsToCsvFile(Collection<T> items) {
        Objects.requireNonNull(items, "Writable items should be initialized first");

        Csv.Writer writer = new Csv.Writer(pathToCsvFile).delimiter(';');

        for (T item : items) {
            String[] lines = itemParser.getLineMassFrom(item);
            for (String line : lines) {
                writer.value(line);
            }
            writer.newLine();
        }

        writer.close();
    }
}
