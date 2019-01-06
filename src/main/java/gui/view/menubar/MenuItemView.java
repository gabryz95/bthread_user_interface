package gui.view.menubar;

import gui.controller.AboutWindowController;
import gui.controller.ChooseFileController;
import gui.controller.ExitController;
import gui.controller.ProcessController;
import gui.command.CommandAbs;
import gui.interfaces.Controller;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

import java.io.IOException;

public class MenuItemView {

    protected MenuItem menuItem;

    public static MenuItemView create(String itemName, final CommandAbs command, final Controller controller) {
        if (itemName == null)
            return null;
        if (command == null)
            return null;
        if (controller == null)
            return null;

        MenuItemView menuItemView = new MenuItemView();
        menuItemView.menuItem = new MenuItem(itemName);
        menuItemView.menuItem.setAccelerator(new KeyCodeCombination(KeyCode.getKeyCode(itemName.substring(0, 1)), KeyCombination.CONTROL_ANY));
        menuItemView.menuItem.setOnAction(e -> {
            try {
                menuItemView.createCommand(controller, command);
                command.execute();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        return menuItemView;
    }

    protected void createCommand(Controller controller, CommandAbs command) {
        if (controller instanceof ProcessController) {
            command.createCommandProcess(controller, MenuBarView.EXECUTABLE_FILE);
        } else if (controller instanceof AboutWindowController) {
            command.createAboutCommand(controller);
        } else if (controller instanceof ExitController) {
            command.createExitCommand(controller);
        } else if (controller instanceof ChooseFileController) {
            command.createChooseFileCommand(controller);
        }
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }
}
