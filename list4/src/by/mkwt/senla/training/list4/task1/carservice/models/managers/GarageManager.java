package by.mkwt.senla.training.list4.task1.carservice.models.managers;

import by.mkwt.senla.training.list4.task1.carservice.table.structure.Table;
import by.mkwt.senla.training.list4.task1.carservice.table.structure.record.Record;
import by.mkwt.senla.training.list4.task1.carservice.table.utils.builders.TableBuilder;
import by.mkwt.senla.training.list4.task1.carservice.table.utils.sorter.RecordSorter;
import by.mkwt.senla.training.list4.task1.carservice.table.utils.textutils.table.TableWriter;
import by.mkwt.senla.training.list4.task1.carservice.models.items.Garage;

import java.util.ArrayList;
import java.util.List;

public class GarageManager {

    private Table garageTable;
    private final String PATH_TO_TABLE = "./resources/table/tables/garages/";

    private List<Garage> garages;

    public GarageManager() {
        garageTable = TableBuilder.buildTableFromFile(PATH_TO_TABLE);
        loadAllGarages();
    }

    public void addGarage(Garage garage) {
        garageTable.getAllRecords().add(garage);
        saveGarages();
        loadAllGarages();
    }

    public void removeGarageById(long id) {
        garageTable.getAllRecords().remove(getGarageById(id));
        saveGarages();
        loadAllGarages();
    }

    private void saveGarages() {
        TableWriter.writeToFile(PATH_TO_TABLE,
                TableBuilder.buildCustomTable(
                        garageTable.getTableName(),
                        garageTable.getFieldNames(),
                        new ArrayList<>(garages)));
    }


    public Garage getGarageById(long id) {
        for (Garage garage : getAllGarages()) {
            if (garage.getId() == id) {
                return garage;
            }
        }

        return null;
    }

    private void loadAllGarages() {
        List<Garage> result = new ArrayList<>();

        for (Record record : garageTable.getAllRecords()) {
            result.add(new Garage(record.getAllFields()));
        }

        garages = result;
    }

    public List<Garage> getAllGarages() {
        return garages;
    }

    public List<Garage> orderGaragesBy(String fieldName, List<Garage> input) {
        RecordSorter<Garage> recordSorter = new RecordSorter<>();
        recordSorter.orderRecordsBy(fieldName, input);
        return input;
    }
}
