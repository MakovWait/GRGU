package by.mkwt.senla.training.list4.task1.carservice.table.utils.sorter;

import by.mkwt.senla.training.list4.task1.carservice.table.structure.record.Record;

import java.util.Comparator;

public class RecordComparator implements Comparator<Record> {

    private String sortedField;

    public RecordComparator(String nameOfField) {

        sortedField = nameOfField;
    }

    @Override
    public int compare(Record o1, Record o2) {
        return o1.getFieldByName(sortedField).compareTo(o2.getFieldByName(sortedField));
    }
}
