package by.mkwt.senla.training.list4.task1.carservice.database.table;

import by.mkwt.senla.training.list4.task1.carservice.database.utils.builders.table.TableBuilder;
import by.mkwt.senla.training.list4.task1.carservice.database.utils.textutils.table.TablePrinter;

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

        mechanics.orderBy("id");

        mechanics.orderBy("name");
    }
}
