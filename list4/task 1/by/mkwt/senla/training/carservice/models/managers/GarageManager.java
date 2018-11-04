package by.mkwt.senla.training.carservice.models.managers;

import by.mkwt.senla.training.carservice.loaders.LoaderComponent;
import by.mkwt.senla.training.carservice.loaders.parsers.GarageParser;
import by.mkwt.senla.training.carservice.models.items.Garage;

import java.util.*;

public class GarageManager {

    private LoaderComponent<Garage> loader;
    private Map<Long, Garage> garages;

    public GarageManager(final String PATH_TO_FILE) {

        loader =  new LoaderComponent<>(new GarageParser(), PATH_TO_FILE);

        loadAllGarages();
    }

    public void addGarage(Garage garage) {
        if(!garages.containsKey(garage.getId())) {
            garages.put(garage.getId(), garage);
            saveGarages();
        }
    }

    public void removeGarageById(Long id) {
        if(garages.containsKey(id)) {
            garages.remove(id);
            saveGarages();
        }
    }

    private void saveGarages() {
        loader.writeItemsToFile(garages.values());
    }


    public Garage getGarageById(Long id) {
        return garages.get(id);
    }

    private void loadAllGarages() {
        garages = new HashMap<>();

        Garage garage;
        while ((garage = loader.getNextItem()) != null) {
            garages.put(garage.getId(), garage);
        }
    }

    public List<Garage> getAllGarages() {
        return new ArrayList<>(garages.values());
    }

}
