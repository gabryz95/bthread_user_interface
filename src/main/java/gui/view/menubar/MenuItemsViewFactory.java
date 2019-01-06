package gui.view.menubar;

import gui.command.CommandAbs;
import gui.interfaces.Controller;

public class MenuItemsViewFactory {

    private static MenuItemsViewFactory menuItemsViewFactory;

    public static MenuItemsViewFactory instance() {
        if (menuItemsViewFactory == null)
            menuItemsViewFactory = new MenuItemsViewFactory();
        return menuItemsViewFactory;
    }

    public MenuItemView createMenuItem(String itemName, final CommandAbs command, final Controller controller) {
        MenuItemView menuItemView = MenuItemView.create(itemName, command, controller);
        return menuItemView;
    }
}
