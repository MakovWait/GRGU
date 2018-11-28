package by.mkwt.senla.training.carservice.logic.models.managers;


import by.mkwt.senla.training.carservice.loaders.LoaderComponent;
import by.mkwt.senla.training.carservice.loaders.parsers.ScheduleParser;
import by.mkwt.senla.training.carservice.logic.exceptions.IllegalIdException;
import by.mkwt.senla.training.carservice.logic.exceptions.IllegalItemLineImplException;
import by.mkwt.senla.training.carservice.logic.exceptions.ItemIsAlreadyExistException;
import by.mkwt.senla.training.carservice.logic.models.items.ScheduleItem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ScheduleManager {

    private LoaderComponent<ScheduleItem> loader;
    private Set<ScheduleItem> scheduleItems;

    public ScheduleManager(final String PATH_TO_FILE) {
        loader = new LoaderComponent<>(new ScheduleParser(), PATH_TO_FILE);
        loadSchedule();
    }

    public void addScheduleItem(ScheduleItem scheduleItem) throws IllegalIdException, ItemIsAlreadyExistException {
        if (scheduleItem.getDate() != null) {
            if (!scheduleItems.add(scheduleItem)) {
                throw new ItemIsAlreadyExistException();
            }
            saveSchedule();
        } else {
            throw new IllegalIdException();
        }

    }

    public ScheduleItem getGarageFromLine(String line) {
        return loader.getItemFromLine(line);
    }

    public List<ScheduleItem> getSchedule() {
        return new ArrayList<>(scheduleItems);
    }

    private void loadSchedule() {
        scheduleItems = new HashSet<>();

        loader.start();
        ScheduleItem scheduleItem;
        while ((scheduleItem = loader.getNextItem()) != null) {
            scheduleItems.add(scheduleItem);
        }

        loader.stop();
    }

    private void saveSchedule() {
        loader.writeItemsToFile(scheduleItems);
    }
}
