package by.mkwt.senla.training.carservice.logic.models.managers;

import by.mkwt.senla.training.carservice.loaders.LoaderComponent;
import by.mkwt.senla.training.carservice.loaders.parsers.GarageParser;
import by.mkwt.senla.training.carservice.logic.exceptions.IllegalIdException;
import by.mkwt.senla.training.carservice.logic.exceptions.IllegalItemLineImplException;
import by.mkwt.senla.training.carservice.logic.exceptions.ItemIsAlreadyExistException;
import by.mkwt.senla.training.carservice.logic.exceptions.NoSuchItemException;
import by.mkwt.senla.training.carservice.logic.models.items.Garage;
import by.mkwt.senla.training.carservice.logic.models.items.Mechanic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GarageManager {

    private LoaderComponent<Garage> loader;
    private Map<Long, Garage> garages;

    public GarageManager(final String PATH_TO_FILE) {
        loader = new LoaderComponent<>(new GarageParser(), PATH_TO_FILE);

        loadAllGarages();
    }

    public void addGarage(Garage garage) throws IllegalIdException, ItemIsAlreadyExistException {
        if (garage == null || garage.getId() == null) {
            throw new IllegalIdException();
        }

        if (garages.containsKey(garage.getId())) {
            throw new ItemIsAlreadyExistException();
        }

        garages.put(garage.getId(), garage);
        saveGarages();
    }


    public void removeGarageById(Long id) throws NoSuchItemException {
        if (!garages.containsKey(id)) {
            throw new NoSuchItemException();
        }

        garages.remove(id);
        saveGarages();
    }

    public Garage getGarageFromLine(String line) {
        return loader.getItemFromLine(line);
    }

    public Garage getGarageById(Long id) {
        return garages.get(id);
    }

    public List<Garage> getAllGarages() {
        return new ArrayList<>(garages.values());
    }

    private void loadAllGarages() {
        garages = new HashMap<>();

        loader.start();
        Garage garage;
        while ((garage = loader.getNextItem()) != null) {
            garages.put(garage.getId(), garage);
        }
        loader.stop();
    }

    private void saveGarages() {
        loader.writeItemsToFile(garages.values());
    }
}

