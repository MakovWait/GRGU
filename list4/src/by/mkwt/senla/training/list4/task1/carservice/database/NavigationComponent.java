package by.mkwt.senla.training.list4.task1.carservice.database;

import com.senla.training.TextFileWorker;

import java.util.HashMap;

public class NavigationComponent {
    HashMap<String, Integer> map;

    NavigationComponent() {
        TextFileWorker fileWorker = new TextFileWorker("./resources/database_tmp/tables/mechanics/description.txt");

        String[] values = fileWorker.readFromFile()[0].split(";");

        map = new HashMap<>();

        int position = 0;

        for (String value : values) {
            map.put(value.toLowerCase(), position);
            position++;
        }
    }
}
