package by.mkwt.senla.training.carservice.loaders;

import com.senla.training.TextFileWorker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LoaderComponent<T> {

    public static final String DELIMITER = "\\|";
    public static final String BORDER = "|";

    private ItemParser<T> itemParser;
    private TextFileWorker textFileWorker;

    private String[] lines;
    private int counter = -1;

    public LoaderComponent(ItemParser<T> itemParser, String pathToFile) {
        this.itemParser = itemParser;
        textFileWorker = new TextFileWorker(pathToFile);

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

    public void writeItemsToFile(Collection<T> items) {
        List<String> result = new ArrayList<>();

        for (T item : items) {
            result.add(itemParser.getLineFrom(item));
        }

        textFileWorker.writeToFile(result.toArray(new String[items.size()]));
    }
}
