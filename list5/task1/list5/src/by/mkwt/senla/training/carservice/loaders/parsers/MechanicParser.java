package by.mkwt.senla.training.carservice.loaders.parsers;


import by.mkwt.senla.training.carservice.loaders.ItemParser;
import by.mkwt.senla.training.carservice.loaders.LoaderComponent;
import by.mkwt.senla.training.carservice.logic.models.items.Mechanic;

public class MechanicParser implements ItemParser<Mechanic> {

    @Override
    public Mechanic getItemFrom(String line) {
        String[] values = line.split(LoaderComponent.DELIMITER);

        Mechanic tmpMechanic = new Mechanic();

        if (values.length > 0) {
            tmpMechanic.setId(Long.parseLong(values[0]));
            tmpMechanic.setName(values[1]);
        }

        return tmpMechanic;
    }

    @Override
    public String getLineFrom(Mechanic item) {
        String[] result = new String[] {
                String.valueOf(item.getId()),
                item.getName()
        };

        return String.join(LoaderComponent.BORDER, result);
    }
}
