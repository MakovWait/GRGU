package by.mkwt.senla.training.list4.task1.carservice.models.managers;

import by.mkwt.senla.training.list4.task1.carservice.utils.file.GarageFileUtil;
import by.mkwt.senla.training.list4.task1.carservice.models.items.Garage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GarageManager implements ItemManager<Garage> {

    private List<Garage> garages;
    private GarageFileUtil garageFileUtil = new GarageFileUtil();

    @Override
    public void buildItemListFromFile() {
        garages = new ArrayList<>(Arrays.asList(garageFileUtil.readFromFile()));
    }

    @Override
    public void addItem(Garage garage) {
        if (garages == null) {
            buildItemListFromFile();
        }

        if (!garages.contains(garage)) {
            garages.add(garage);
        } else {
            System.out.print("This garage is already exist");
        }
        saveItemList();
    }

    @Override
    public void removeItem(Garage garage) {
        garages.remove(garage);
        saveItemList();
    }

    @Override
    public void saveItemList() {

        garageFileUtil.writeToFile(garages.toArray(new Garage[garages.size()]));
    }

    public List<Garage> getGarages() {
        return garages;
    }

    public Garage getGarageByID(Long id) {
        for (Garage garage : garages) {
            if (garage.getId().equals(id)) {
                return garage;
            }
        }
        return null;
    }
}
