package by.mkwt.senla.training.list4.task1.carservice.utils.file;

import by.mkwt.senla.training.list4.task1.carservice.models.items.Mechanic;
import com.senla.training.FileWorker;
import com.senla.training.TextFileWorker;
import com.senla.training.example.FileUtil;

public class MechanicFileUtil implements FileUtil<Mechanic> {

    private static final String MECHANICS_FILE = "./resources/database/tables/mechanics.txt";

    private final FileWorker fileWorker;

    public MechanicFileUtil() {
        fileWorker = new TextFileWorker(MECHANICS_FILE);
    }

    @Override
    public Mechanic[] readFromFile() {
        final String[] lines = fileWorker.readFromFile();

        if (lines == null || lines.length == 0) {
            throw new IllegalArgumentException();
        }

        final Mechanic[] result = new Mechanic[lines.length];

        for (int i = 0; i < lines.length; i++) {
            result[i] = fromLine(lines[i]);
        }

        return result;
    }

    @Override
    public void writeToFile(Mechanic[] values) {
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
    public String toLine(final Mechanic mechanic) {

        if (mechanic == null) {
            throw new IllegalArgumentException();
        }

        return mechanic.toLine();
    }

    @Override
    public Mechanic fromLine(String line) {

        if (line == null || line.isEmpty()) {
            throw new IllegalArgumentException();
        }
        final String[] parts = line.split("\\|");

        final Mechanic result = new Mechanic(
                Long.valueOf(parts[0]),
                parts[1]
        );
        return result;
    }
}
