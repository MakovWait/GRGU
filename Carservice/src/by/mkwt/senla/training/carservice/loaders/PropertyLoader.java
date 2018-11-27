package by.mkwt.senla.training.carservice.loaders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class PropertyLoader {

    private Properties properties;
    private final String pathToProperties;

    public PropertyLoader(final String pathToProperties) {
        Objects.requireNonNull(pathToProperties);
        this.pathToProperties = pathToProperties;

        loadData();
    }

    private void loadData() {
        FileInputStream fis;
        properties = new Properties();

        try {
            fis = new FileInputStream(pathToProperties);
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
