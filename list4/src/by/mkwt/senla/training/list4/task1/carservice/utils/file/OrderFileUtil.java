package by.mkwt.senla.training.list4.task1.carservice.utils.file;

import by.mkwt.senla.training.list4.task1.carservice.models.items.Order;
import by.mkwt.senla.training.list4.task1.carservice.models.items.OrderState;
import com.senla.training.FileWorker;
import com.senla.training.TextFileWorker;
import com.senla.training.example.FileUtil;

import java.math.BigDecimal;
import java.util.Date;

public class OrderFileUtil implements FileUtil<Order> {
    private static final String ORDERS_FILE = "./resources/database/tables/orders.txt";

    private final FileWorker fileWorker;

    public OrderFileUtil() {
        fileWorker = new TextFileWorker(ORDERS_FILE);
    }

    @Override
    public Order[] readFromFile() {
        final String[] lines = fileWorker.readFromFile();

        if (lines == null || lines.length == 0) {
            throw new IllegalArgumentException();
        }

        final Order[] result = new Order[lines.length];

        for (int i = 0; i < lines.length; i++) {
            result[i] = fromLine(lines[i]);
        }

        return result;
    }

    @Override
    public void writeToFile(Order[] values) {
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
    public String toLine(final Order order) {

        if (order == null) {
            throw new IllegalArgumentException();
        }

        return order.toLine();
    }

    @Override
    public Order fromLine(String line) {

        if (line == null || line.isEmpty()) {
            throw new IllegalArgumentException();
        }
        final String[] parts = line.split("\\|");

        final Order result = new Order(
                Long.valueOf(parts[0]),
                new Date(Long.parseLong(parts[1])),
                new Date(Long.parseLong(parts[2])),
                new Date(Long.parseLong(parts[3])),
                new BigDecimal(Float.parseFloat(parts[4])),
                OrderState.valueOf(parts[5])
        );
        return result;
    }
}
