package by.mkwt.senla.training.carservice.models.managers;

import by.mkwt.senla.training.carservice.loaders.LoaderComponent;
import by.mkwt.senla.training.carservice.loaders.parsers.ScheduleParser;
import by.mkwt.senla.training.carservice.models.items.ScheduleItem;

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

    public void addScheduleItem(ScheduleItem scheduleItem) {
            scheduleItems.add(scheduleItem);
            saveSchedule();

    }

    private void loadSchedule() {
        scheduleItems = new HashSet<>();

        ScheduleItem scheduleItem;
        while ((scheduleItem = loader.getNextItem()) != null) {
            scheduleItems.add(scheduleItem);
        }
    }

    public List<ScheduleItem> getSchedule() {
        return new ArrayList<>(scheduleItems);
    }

    private void saveSchedule() {
        loader.writeItemsToFile(scheduleItems);
    }
}
