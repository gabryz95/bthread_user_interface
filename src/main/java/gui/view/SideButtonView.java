package gui.view;

import gui.controller.ProcessController;
import gui.interfaces.CommandAbs;
import gui.model.ObserverList;
import gui.view.menubar.MenuBarView;
import javafx.scene.control.Button;

import java.io.IOException;

public class SideButtonView {
    protected final Button button;

    //TODO: DA SISTEMARE!!!!!! urgente! non deve disattivare tutti i menu
    public SideButtonView(String styleClassName, final CommandAbs command, final ProcessController controller, final ObserverList observerList) {
        this.button = new Button();
        this.button.setOnAction(e -> {
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
        this.button.getStyleClass().add(styleClassName);
    }

    public Button getSideButton() {
        return button;
    }
}
