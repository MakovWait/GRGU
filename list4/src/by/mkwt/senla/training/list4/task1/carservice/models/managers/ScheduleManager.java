package by.mkwt.senla.training.list4.task1.carservice.models.managers;

import by.mkwt.senla.training.list4.task1.carservice.utils.file.ScheduleFileUtil;
import by.mkwt.senla.training.list4.task1.carservice.models.items.Schedule;

import java.util.ArrayList;
import java.util.Arrays;

public class ScheduleManager implements ItemManager<Schedule> {

    private ArrayList<Schedule> schedules;
    private ScheduleFileUtil scheduleFileUtil = new ScheduleFileUtil();

    @Override
    public void buildItemListFromFile() {

        schedules = new ArrayList<>(Arrays.asList(scheduleFileUtil.readFromFile()));
    }

    @Override
    public void addItem(Schedule schedule) {
        if (schedules == null) {
            System.out.print("The schedules should be initialized first");
            return;
        }

        if (!schedules.contains(schedule)) {
            schedules.add(schedule);
        } else {
            System.out.print("This schedule is already exist");
        }
        saveItemList();
    }

    @Override
    public void removeItem(Schedule schedule) {
        schedules.remove(schedule);
        saveItemList();
    }

    @Override
    public void saveItemList() {
        scheduleFileUtil.writeToFile(schedules.toArray(new Schedule[schedules.size()]));
    }

    @Override
    public void print() {
        for (Schedule item : schedules) {
            System.out.println(item.toLine());
        }
    }

    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }
}
