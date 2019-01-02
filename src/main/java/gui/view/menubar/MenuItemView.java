package gui.view.menubar;

import gui.controller.ProcessController;
import gui.command.CommandAbs;
import gui.model.ObserverList;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

import java.io.IOException;

//Implementare metodo create
public class MenuItemView {

    protected final MenuItem menuItem;

    //TODO: DA SISTEMARE!!!!!! urgente! non deve disattivare tutti i menu
    public MenuItemView(String itemName, final CommandAbs command, final ProcessController controller, final ObserverList observerList) {
        this.menuItem = new MenuItem(itemName);
        this.menuItem.setAccelerator(new KeyCodeCombination(KeyCode.getKeyCode(itemName.substring(0, 1)), KeyCombination.CONTROL_ANY));
        this.menuItem.setOnAction(e -> {
            if (command != null) {
                try {
                    for (int i = 0; i < observerList.size(); i++)
                        command.addObserver(observerList.getObserver(i));
                    command.create(controller, MenuBarView.EXECUTABLE_FILE);
                    command.execute();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }
}
