package gui.view.buttonbar;

import gui.command.CommandAbs;
import gui.controller.ChooseFileController;
import gui.controller.ProcessController;
import gui.interfaces.Controller;
import gui.view.menubar.MenuBarView;
import javafx.scene.control.Button;

import java.io.IOException;

public class SideButtonView {

    protected Button button;

    public static SideButtonView create(String styleClassName, final CommandAbs command, final Controller controller) {

        if (styleClassName == null)
            return null;
        if (command == null)
            return null;
        if (controller == null)
            return null;

        SideButtonView sideButtonView = new SideButtonView();
        sideButtonView.button = new Button();
        sideButtonView.button.getStyleClass().add(styleClassName);
        sideButtonView.button.setOnAction(e -> {
            try {
                sideButtonView.createCommand(controller, command);
                command.execute();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        return sideButtonView;
    }

    protected void createCommand(Controller controller, CommandAbs command) {
        if (controller instanceof ProcessController) {
            command.createCommandProcess(controller, MenuBarView.EXECUTABLE_FILE);
        } else if (controller instanceof ChooseFileController) {
            command.createChooseFileCommand(controller);
        }
    }

    public Button getSideButton() {
        return button;
    }
}
