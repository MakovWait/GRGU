package by.mkwt.senla.training.carservice.models.managers;

import by.mkwt.senla.training.carservice.loaders.LoaderComponent;
import by.mkwt.senla.training.carservice.loaders.parsers.MechanicParser;
import by.mkwt.senla.training.carservice.models.items.Mechanic;
import by.mkwt.senla.training.carservice.sorters.MechanicOrderableValues;
import by.mkwt.senla.training.carservice.sorters.MechanicSorter;

import java.util.*;

public class MechanicManager {

    private final String PATH_TO_FILE = "./resources/database/tables/mechanics/values.txt";

    private LoaderComponent<Mechanic> loader;
    private MechanicSorter sorter;
    private Map<Long, Mechanic> mechanics;

    public MechanicManager() {
        loader = new LoaderComponent<>(new MechanicParser(), PATH_TO_FILE);
        sorter = new MechanicSorter();

        loadAllMechanics();
    }

    public void addMechanic(Mechanic mechanic) {
        if (!mechanics.containsKey(mechanic.getId())) {
            mechanics.put(mechanic.getId(), mechanic);
            saveMechanics();
        }
    }

    public void removeMechanicById(long id) {
        if (mechanics.containsKey(id)) {
            mechanics.remove(id);
            saveMechanics();
        }
    }

    private void saveMechanics() {
        loader.writeItemsToFile(mechanics.values());
    }

    public Mechanic getMechanicById(long id) {
        return mechanics.get(id);
    }

    private void loadAllMechanics() {
        mechanics = new HashMap<>();
        Mechanic mechanic;
        while ((mechanic = loader.getNextItem()) != null) {
            mechanics.put(mechanic.getId(), mechanic);
        }
    }

    public List<Mechanic> getAllMechanics() {
        return new ArrayList<>(mechanics.values());
    }

    public List<Mechanic>  orderBy(MechanicOrderableValues value) {
        return sorter.orderBy(value, getAllMechanics());
    }
}
