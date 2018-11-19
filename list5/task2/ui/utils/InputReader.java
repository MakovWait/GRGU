package by.mkwt.senla.training.carservice.ui.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InputReader {

    private static InputReader instance;

    private SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    private Scanner scanner;

    private InputReader() {
        scanner = new Scanner(System.in);
    }

    public static InputReader getInstance() {
        if (instance == null) {
            instance = new InputReader();
        }
        return instance;
    }

    public String listenInput(String message) {
        System.out.print(message);
        return scanner.next();
    }

    public String listenInput() {
        return scanner.next();
    }

    public Date parseIntoDate(String line) throws ParseException {
        return format.parse(line);
    }

    public long parseIntoId(String line) {
        try {
            return Long.parseLong(line);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public int parseIntoNavigateInstruction(String line) {
        final int DEFAULT_VALUE = -2;
        try {
            return Integer.parseInt(line) - 1;
        } catch (NumberFormatException e) {
            return DEFAULT_VALUE;
        }
    }

    public void dispose() {
        scanner.close();
        instance = null;
    }
}
