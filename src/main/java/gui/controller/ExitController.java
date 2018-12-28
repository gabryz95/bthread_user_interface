package gui.controller;

import javafx.stage.Stage;

public class ExitController {
    private Stage stage;
    private ProcessController receiver;

    public ExitController(Stage stage, ProcessController model) {
        this.stage = stage;
        this.receiver = model;
    }

    public void execute() {
        if (stage == null)
            return;

        if (receiver == null)
            return;

        receiver.exitProcess();
        stage.close();
    }
}
