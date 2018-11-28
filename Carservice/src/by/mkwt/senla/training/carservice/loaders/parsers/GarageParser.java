package by.mkwt.senla.training.carservice.loaders.parsers;


import by.mkwt.senla.training.carservice.loaders.ItemParser;
import by.mkwt.senla.training.carservice.loaders.LoaderComponent;
import by.mkwt.senla.training.carservice.logic.exceptions.IllegalItemLineImplException;
import by.mkwt.senla.training.carservice.logic.models.items.Garage;

import java.security.spec.ECField;
import java.util.Objects;

public class GarageParser implements ItemParser<Garage> {

    @Override
    public Garage getItemFrom(String line) {
        String[] values = line.split(LoaderComponent.DELIMITER);

        Garage tmpGarage = new Garage();

        tmpGarage.setId(Long.parseLong(values[0]));

        return tmpGarage;
    }

    @Override
    public String[] getLineMassFrom(Garage item) {
        return new String[]{
                String.valueOf(item.getId())
        };
    }

}
