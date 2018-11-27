package by.mkwt.senla.training.carservice.logic.exceptions;

public class NoSuchItemException extends Exception {

    public NoSuchItemException() {

    }

    public NoSuchItemException(String message) {
        super(message + "\n Try with another id.");
    }
}
