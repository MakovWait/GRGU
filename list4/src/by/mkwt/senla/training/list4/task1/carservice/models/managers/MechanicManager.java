package by.mkwt.senla.training.list4.task1.carservice.models.managers;

import by.mkwt.senla.training.list4.task1.carservice.utils.file.MechanicFileUtil;
import by.mkwt.senla.training.list4.task1.carservice.models.items.Mechanic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MechanicManager implements ItemManager<Mechanic> {

    private List<Mechanic> mechanics;
    private MechanicFileUtil mechanicFileUtil = new MechanicFileUtil();

    @Override
    public void buildItemListFromFile() {
        mechanics = new ArrayList<>(Arrays.asList(mechanicFileUtil.readFromFile()));
    }

    @Override
    public void addItem(Mechanic mechanic) {
        if (mechanics == null) {
            buildItemListFromFile();
            return;
        }

        if (!mechanics.contains(mechanic)) {
            mechanics.add(mechanic);
        } else {
            System.out.print("This mechanic is already exist");
        }
        saveItemList();
    }

    @Override
    public void removeItem(Mechanic mechanic) {
        mechanics.remove(mechanic);
        saveItemList();
    }

    @Override
    public void saveItemList() {
        mechanicFileUtil.writeToFile(mechanics.toArray(new Mechanic[mechanics.size()]));
    }

    public List<Mechanic> getMechanics() {
        return mechanics;
    }

    public Mechanic getMechanicById(Long id) {
        for (Mechanic mechanic : mechanics) {
            if (mechanic.getId().equals(id)) {
                return mechanic;
            }
        }
        return null;
    }

}
