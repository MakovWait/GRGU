package by.mkwt.senla.training.carservice.sorters;

import by.mkwt.senla.training.carservice.models.items.Mechanic;

import java.util.*;

public class MechanicSorter {

    public List<Mechanic> orderBy(MechanicOrderableValues value, List<Mechanic> mechanics) {
        switch (value) {
            case byName:
                return orderByName(mechanics);
            case byBusyness:
                return orderByBusyness(mechanics);
            default:
                return mechanics;
        }
    }

    private List<Mechanic> orderByName(List<Mechanic> mechanics) {
        Collections.sort(mechanics, (o1, o2) -> o1.getName().compareTo(o2.getName()));

        return mechanics;
    }

    private List<Mechanic> orderByBusyness(List<Mechanic> mechanics) {
        Collections.sort(mechanics, (o1, o2) -> Integer.valueOf(o1.getBusyness()).compareTo(o2.getBusyness()));

        return mechanics;
    }

}
