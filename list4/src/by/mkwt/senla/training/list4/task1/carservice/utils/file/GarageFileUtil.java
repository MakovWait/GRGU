package by.mkwt.senla.training.list4.task1.carservice.utils.file;

import by.mkwt.senla.training.list4.task1.carservice.models.items.Garage;
import com.senla.training.FileWorker;
import com.senla.training.TextFileWorker;
import com.senla.training.example.FileUtil;

public class GarageFileUtil implements FileUtil<Garage> {

    private final String GARAGES_FILE = "./resources/database/tables/garages.txt";

    private final FileWorker fileWorker;

    public GarageFileUtil() {
        fileWorker = new TextFileWorker(GARAGES_FILE);
    }

    @Override
    public Garage[] readFromFile() {
        final String[] lines = fileWorker.readFromFile();

        if (lines == null || lines.length == 0) {
            throw new IllegalArgumentException();
        }

        final Garage[] result = new Garage[lines.length];

        for (int i = 0; i < lines.length; i++) {
            result[i] = fromLine(lines[i]);
        }

        return result;
    }

    @Override
    public void writeToFile(Garage[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException();
        }
        final String[] lines = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            lines[i] = toLine(values[i]);
        }
        fileWorker.writeToFile(lines);
    }

    @Override
    public String toLine(final Garage garage) {

        if (garage == null) {
            throw new IllegalArgumentException();
        }

        return garage.toLine();
    }

    @Override
    public Garage fromLine(String line) {

        if (line == null || line.isEmpty()) {
            throw new IllegalArgumentException();
        }
        final String[] parts = line.split("\\|");

        final Garage result = new Garage(
                Long.valueOf(parts[0])
        );
        return result;
    }
}
