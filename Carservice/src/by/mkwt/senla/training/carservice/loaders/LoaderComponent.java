package by.mkwt.senla.training.carservice.loaders;

import by.mkwt.senla.training.carservice.logic.exceptions.IllegalItemLineImplException;
import com.senla.training.TextFileWorker;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class LoaderComponent<T> {

    public static final String DELIMITER = "\\|";
    public static final String BORDER = "|";

    private ItemParser<T> itemParser;
    private TextFileWorker textFileWorker;

    private String[] lines;
    private int counter = -1;

    public LoaderComponent(ItemParser<T> itemParser, String pathToFile) {
        this.itemParser = Objects.requireNonNull(itemParser, "Item parser shouldn't be null");
        textFileWorker = new TextFileWorker(Objects.requireNonNull(pathToFile));

        lines = textFileWorker.readFromFile();
    }

    public T getNextItem() {
        if (counterIncrement()) {
            return itemParser.getItemFrom(lines[counter]);
        }

        return null;
    }

    private boolean counterIncrement() {
        counter++;

        return counter < lines.length;
    }

    public T getItemFromLine(String line) {
        return itemParser.getItemFrom(line);
    }

    public void writeItemsToFile(Collection<T> items) {
        Objects.requireNonNull(items, "Writable items should be initialized first");
        List<String> result = new ArrayList<>();

        for (T item : items) {
            result.add(itemParser.getLineFrom(item));
        }

        textFileWorker.writeToFile(result.toArray(new String[items.size()]));
    }
}
