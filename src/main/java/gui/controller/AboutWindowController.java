package gui.controller;

import gui.interfaces.AboutWindowManager;
import gui.interfaces.Controller;
import javafx.stage.Stage;

public class AboutWindowController extends Controller implements AboutWindowManager {

    protected Stage stage;
    protected AboutWindowManager receiver;

    public static AboutWindowController create(Stage stage, AboutWindowManager receiver) {
        if (stage == null)
            return null;

        if (receiver == null)
            return null;

        AboutWindowController aboutWindowController = new AboutWindowController();
        aboutWindowController.stage = stage;
        aboutWindowController.receiver = receiver;
        return aboutWindowController;
    }


    @Override
    public void aboutWindow() {
        receiver.aboutWindow();
    }
}
