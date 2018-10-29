package by.mkwt.senla.training.list4.task1.carservice.models.managers;

import by.mkwt.senla.training.list4.task1.carservice.table.structure.Table;
import by.mkwt.senla.training.list4.task1.carservice.table.structure.record.Record;
import by.mkwt.senla.training.list4.task1.carservice.table.utils.builders.TableBuilder;
import by.mkwt.senla.training.list4.task1.carservice.table.utils.sorter.RecordSorter;
import by.mkwt.senla.training.list4.task1.carservice.table.utils.textutils.table.TableWriter;
import by.mkwt.senla.training.list4.task1.carservice.models.items.Mechanic;

import java.util.ArrayList;
import java.util.List;

public class MechanicManager {

    private Table mechanicTable;

    private final String PATH_TO_TABLE = "./resources/table/tables/mechanics/";

    private List<Mechanic> mechanics;

    public MechanicManager() {
        mechanicTable = TableBuilder.buildTableFromFile(PATH_TO_TABLE);

        loadAllMechanics();
    }

    public void addMechanic(Mechanic mechanic) {
        mechanicTable.getAllRecords().add(mechanic);
        saveMechanics();
    }

    public void removeMechanicById(long id) {
        mechanicTable.getAllRecords().remove(getMechanicById(id));
        saveMechanics();
    }

    private void saveMechanics() {
        TableWriter.writeToFile(PATH_TO_TABLE, mechanicTable);
    }

    public Mechanic getMechanicById(long id) {
        for (Mechanic mechanic : getAllMechanics()) {
            if (mechanic.getId() == id) {
                return mechanic;
            }
        }

        return null;
    }

    private void loadAllMechanics() {
        List<Mechanic> result = new ArrayList<>();

        for (Record record : mechanicTable.getAllRecords()) {
            result.add(new Mechanic(record.getAllFields()));
        }

        mechanics = result;
    }

    public List<Mechanic> getAllMechanics() {
        return mechanics;
    }

    public List<Mechanic> orderMechanicsBy(String fieldName, List<Mechanic> input) {
        RecordSorter<Mechanic> recordSorter = new RecordSorter<>();
        recordSorter.orderRecordsBy(fieldName, input);
        return input;
    }
}
