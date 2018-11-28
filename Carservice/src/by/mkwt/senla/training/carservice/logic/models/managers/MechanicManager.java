package by.mkwt.senla.training.carservice.logic.models.managers;

import by.mkwt.senla.training.carservice.loaders.LoaderComponent;
import by.mkwt.senla.training.carservice.loaders.parsers.MechanicParser;
import by.mkwt.senla.training.carservice.logic.exceptions.IllegalIdException;
import by.mkwt.senla.training.carservice.logic.exceptions.IllegalItemLineImplException;
import by.mkwt.senla.training.carservice.logic.exceptions.ItemIsAlreadyExistException;
import by.mkwt.senla.training.carservice.logic.exceptions.NoSuchItemException;
import by.mkwt.senla.training.carservice.logic.models.items.Garage;
import by.mkwt.senla.training.carservice.logic.models.items.Mechanic;
import by.mkwt.senla.training.carservice.logic.models.sorters.MechanicOrderableValues;
import by.mkwt.senla.training.carservice.logic.models.sorters.MechanicSorter;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MechanicManager {

    private LoaderComponent<Mechanic> loader;
    private MechanicSorter sorter;
    private Map<Long, Mechanic> mechanics;

    public MechanicManager(final String PATH_TO_FILE) {
        final String PATH_TO_CSV_FILE = "./resources/database/csv/mechanics.csv";

        loader = new LoaderComponent<>(new MechanicParser(), PATH_TO_FILE, PATH_TO_CSV_FILE);
        sorter = new MechanicSorter();

        loadAllMechanics();
    }

    public void addMechanic(Mechanic mechanic) throws IllegalIdException, ItemIsAlreadyExistException {
        if (mechanic == null || mechanic.getId() == null) {
            throw new IllegalIdException();
        }

        if (mechanics.containsKey(mechanic.getId())) {
            throw new ItemIsAlreadyExistException();
        }

        mechanics.put(mechanic.getId(), mechanic);
        saveMechanics();
    }

    public void importFromCsv() throws FileNotFoundException {
        List<Mechanic> importItems = loader.getItemsFromCsvFile();

        for (Mechanic item : importItems) {
            mechanics.put(item.getId(), item);
        }
    }

    public void exportToCsv() {
        loader.writeItemsToCsvFile(getAllMechanics());
    }

    public void removeMechanicById(Long id) throws NoSuchItemException {
        if (!mechanics.containsKey(id)) {
            throw new NoSuchItemException();
        }

        mechanics.remove(id);
        saveMechanics();
    }

    public Mechanic getMechanicFromLine(String line) {
        return loader.getItemFromLine(line);
    }

    public Mechanic getMechanicById(long id) {
        return mechanics.get(id);
    }

    public List<Mechanic> getAllMechanics() {
        return new ArrayList<>(mechanics.values());
    }

    public List<Mechanic> orderBy(MechanicOrderableValues value) {
        return sorter.orderBy(value, getAllMechanics());
    }

    private void saveMechanics() {
        loader.writeItemsToFile(mechanics.values());
    }

    private void loadAllMechanics() {
        mechanics = new HashMap<>();

        loader.start();
        Mechanic mechanic;
        while ((mechanic = loader.getNextItem()) != null) {
            mechanics.put(mechanic.getId(), mechanic);
        }
        loader.stop();
    }


}
