package by.mkwt.senla.training.list4.task1.carservice.utils.file;

import by.mkwt.senla.training.list4.task1.carservice.models.items.Schedule;
import com.senla.training.FileWorker;
import com.senla.training.TextFileWorker;
import com.senla.training.example.FileUtil;

import java.util.Date;

public class ScheduleFileUtil implements FileUtil<Schedule> {
    private static final String SCHEDULES_FILE = "./resources/database/tables/schedules.txt";

    private final FileWorker fileWorker;

    public ScheduleFileUtil() {
        fileWorker = new TextFileWorker(SCHEDULES_FILE);
    }

    @Override
    public Schedule[] readFromFile() {
        final String[] lines = fileWorker.readFromFile();

        if (lines == null || lines.length == 0) {
            throw new IllegalArgumentException();
        }

        final Schedule[] result = new Schedule[lines.length];

        for (int i = 0; i < lines.length; i++) {
            result[i] = fromLine(lines[i]);
        }

        return result;
    }

    @Override
    public void writeToFile(Schedule[] values) {
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
    public String toLine(final Schedule schedule) {

        if (schedule == null) {
            throw new IllegalArgumentException();
        }

        return schedule.toLine();
    }

    @Override
    public Schedule fromLine(String line) {

        if (line == null || line.isEmpty()) {
            throw new IllegalArgumentException();
        }
        final String[] parts = line.split("\\|");

        final Schedule result = new Schedule(
                new Date(Long.parseLong(parts[0])),
                Long.parseLong(parts[1]),
                Long.parseLong(parts[2]),
                Long.parseLong(parts[3])
        );
        return result;
    }
}
