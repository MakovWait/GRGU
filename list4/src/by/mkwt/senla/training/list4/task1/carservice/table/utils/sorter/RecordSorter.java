package by.mkwt.senla.training.list4.task1.carservice.table.utils.sorter;

import by.mkwt.senla.training.list4.task1.carservice.table.structure.record.Record;

import java.util.List;

public class RecordSorter <T extends Record>{

    public void  orderRecordsBy(String fieldName, List<T> records) {
        RecordComparator recordComparator = new RecordComparator(fieldName);
        records.sort(recordComparator);
    }
}
