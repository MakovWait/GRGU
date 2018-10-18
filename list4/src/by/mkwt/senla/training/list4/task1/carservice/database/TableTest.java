package by.mkwt.senla.training.list4.task1.carService.database;

import by.mkwt.senla.training.list4.task1.carService.database.table.Table;
import by.mkwt.senla.training.list4.task1.carService.database.table.TableBuilder;
import by.mkwt.senla.training.list4.task1.carService.database.utils.TableSorter;
import by.mkwt.senla.training.list4.task1.carService.database.utils.TablePrinter;

import java.util.Arrays;

public class TableTest {
    public static final String FILE_PATH_TO_VALUES_OF_MECHANICS_TABLE = "./resources/database/tables/mechanics/values.txt";
    public static final String FILE_PATH_TO_DESCRIPTION_OF_MECHANICS_TABLE = "./resources/database/tables/mechanics/description.txt";

    public static final String FILE_PATH_TO_VALUES_OF_ORDERS_TABLE = "./resources/database/tables/orders/values.txt";
    public static final String FILE_PATH_TO_DESCRIPTION_OF_ORDERS_TABLE = "./resources/database/tables/orders/description.txt";


    public static void main(String[] args) {

        Table mechanics = TableBuilder.buildTableFromFile(FILE_PATH_TO_VALUES_OF_MECHANICS_TABLE, FILE_PATH_TO_DESCRIPTION_OF_MECHANICS_TABLE);
        Table orders = TableBuilder.buildTableFromFile(FILE_PATH_TO_VALUES_OF_ORDERS_TABLE, FILE_PATH_TO_DESCRIPTION_OF_ORDERS_TABLE);

        TablePrinter.print(mechanics);
        TablePrinter.print(orders);

        TableSorter tableSorter = new TableSorter();

        tableSorter.setSortedField("name");

        mechanics.orderBy("id");

        mechanics.orderBy("name");
        TablePrinter.print(mechanics);
    }
}
