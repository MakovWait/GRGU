package by.mkwt.senla.training.list4.task1.carservice.models.managers;

import by.mkwt.senla.training.list4.task1.carservice.table.structure.Table;
import by.mkwt.senla.training.list4.task1.carservice.table.structure.record.Record;
import by.mkwt.senla.training.list4.task1.carservice.table.utils.builders.TableBuilder;
import by.mkwt.senla.training.list4.task1.carservice.table.utils.textutils.table.TableWriter;
import by.mkwt.senla.training.list4.task1.carservice.models.items.ScheduleItem;

import java.util.ArrayList;
import java.util.List;

public class ScheduleManager {

    private Table scheduleTable;
    private final String PATH_TO_TABLE = "./resources/table/tables/schedule/";

    private List<ScheduleItem> scheduleItems;

    public ScheduleManager() {
        scheduleTable = TableBuilder.buildTableFromFile(PATH_TO_TABLE);
        loadSchedule();
    }

    public void addScheduleItem(ScheduleItem scheduleItem) {
        scheduleTable.getAllRecords().add(scheduleItem);
        saveSchedule();
    }

    public void loadSchedule() {
        List<ScheduleItem> result = new ArrayList<>();

        for (Record record : scheduleTable.getAllRecords()) {
            result.add(new ScheduleItem(record.getAllFields()));
        }

        scheduleItems = result;
    }

    public List<ScheduleItem> getSchedule() {

        return scheduleItems;
    }

    private void saveSchedule() {
        TableWriter.writeToFile(PATH_TO_TABLE, scheduleTable);
    }
}
