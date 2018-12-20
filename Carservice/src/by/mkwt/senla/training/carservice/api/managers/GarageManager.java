package by.mkwt.senla.training.carservice.api.managers;

import by.mkwt.senla.training.carservice.logic.exceptions.IllegalIdException;
import by.mkwt.senla.training.carservice.logic.exceptions.ItemIsAlreadyExistException;
import by.mkwt.senla.training.carservice.logic.exceptions.NoSuchItemException;
import by.mkwt.senla.training.carservice.logic.models.items.Garage;

import java.io.FileNotFoundException;
import java.util.List;

public interface GarageManager {

    void addGarage(Garage garage) throws IllegalIdException, ItemIsAlreadyExistException;

    void removeGarageById(Long id) throws NoSuchItemException;

    void importFromCsv() throws FileNotFoundException;

    void exportToCsv();

    Garage getGarageFromLine(String line);

    Garage getGarageById(Long id);

    List<Garage> getAllGarages();

}
