package gui.controller;

import javafx.stage.Stage;

public class AboutWindowController {
    private Stage stage;
    private ProcessController receiver;

    public AboutWindowController(Stage stage, ProcessController receiver) {
        this.stage = stage;
        this.receiver = receiver;
    }

    public void execute() {
        if (stage == null)
            return;

        if (receiver == null)
            return;

        receiver.aboutWindow();
    }
}
