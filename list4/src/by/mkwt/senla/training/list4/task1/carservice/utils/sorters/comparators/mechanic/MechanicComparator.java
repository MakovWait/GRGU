package by.mkwt.senla.training.list4.task1.carservice.utils.sorters.comparators.mechanic;

import by.mkwt.senla.training.list4.task1.carservice.models.items.Mechanic;

import java.util.Comparator;

public class MechanicComparator implements Comparator<Mechanic> {

    MechanicCompareTypes type;

    public MechanicComparator() {
        type = MechanicCompareTypes.byName;
    }

    @Override
    public int compare(Mechanic o1, Mechanic o2) {
        switch (type) {
            case byName:
                return o1.getName().compareTo(o2.getName());
            default:
                return 0;
        }
    }

    public void setCompareType(MechanicCompareTypes type) {
        this.type = type;
    }
}
