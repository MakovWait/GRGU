package by.mkwt.senla.training.list4.task1.carservice.models.managers;

import by.mkwt.senla.training.list4.task1.carservice.utils.file.MechanicFileUtil;
import by.mkwt.senla.training.list4.task1.carservice.models.items.Mechanic;

import java.util.ArrayList;
import java.util.Arrays;

public class MechanicManager implements ItemManager<Mechanic> {

    private ArrayList<Mechanic> mechanics;
    private MechanicFileUtil mechanicFileUtil = new MechanicFileUtil();

    @Override
    public void buildItemListFromFile() {
        mechanics = new ArrayList<>(Arrays.asList(mechanicFileUtil.readFromFile()));
    }

    @Override
    public void addItem(Mechanic mechanic) {
        if (mechanics == null) {
            System.out.print("The mechanics should be initialized first");
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

    public ArrayList<Mechanic> getMechanics() {
        return mechanics;
    }

    public Mechanic getMechanicByID(Long id) {
        for (Mechanic mechanic : mechanics) {
            if (mechanic.getId().equals(id)) {
                return mechanic;
            }
        }
        return null;
    }

    @Override
    public void print() {
        for (Mechanic item : mechanics) {
            System.out.println(item.toLine());
        }
    }
}
