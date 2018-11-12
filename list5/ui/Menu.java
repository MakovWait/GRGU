package by.mkwt.senla.training.carservice.ui;

public class Menu {

    private String name;
    private MenuItem[] menuItems;

    public Menu(String name, MenuItem[] menuItems) {
        this.name = namePreprocessor(name);
        this.menuItems = menuItems;
    }

    private String namePreprocessor(String inputName) {
        return  "~" + inputName + "~";
    }

    public String getName() {
        return name;
    }

    public MenuItem getMenuItemByIndex(int index) {
        if(index >= 0 && index < menuItems.length) {
            return menuItems[index];
        }

        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(name).append("\n");

        for (int i = 0; i < menuItems.length; i++) {
            builder.append(i + 1).append(". ").append(menuItems[i].getTitle()).append("\n");
        }

        return builder.toString();
    }
}
