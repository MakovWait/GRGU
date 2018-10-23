package by.mkwt.senla.training.list4.task1.carservice.utils.sorters;

import by.mkwt.senla.training.list4.task1.carservice.utils.sorters.comparators.mechanic.MechanicCompareTypes;
import by.mkwt.senla.training.list4.task1.carservice.utils.sorters.comparators.mechanic.MechanicComparator;

public class MechanicSorter {
    private MechanicComparator mechanicComparator;

    public MechanicSorter() {
        mechanicComparator = new MechanicComparator();
    }

    public MechanicComparator orderBy(MechanicCompareTypes type) {
        mechanicComparator.setCompareType(type);
        return mechanicComparator;
    }
}
