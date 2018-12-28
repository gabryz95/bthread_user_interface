package gui.controller;

import gui.interfaces.ChooserFileManager;
import gui.view.menubar.MenuBarView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.File;

public class ChooseFileController implements ChooserFileManager {

    private Stage stage;
    private ProcessController receiver;
    private final FileChooser fileChooser;

    public ChooseFileController(Stage stage, ProcessController model) {
        this.stage = stage;
        this.receiver = model;
        fileChooser = new FileChooser();
    }

    public void execute() {
        if (stage == null)
            return;

        try {
            File file = fileChooser.showOpenDialog(stage);
            if (isValid(file)) {
                MenuBarView.EXECUTABLE_FILE = file.getAbsolutePath();
                receiver.chooseFileProcess();
            }
        } catch (final NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isValid(final File file) {

        boolean eseguibile = file.canExecute();
        boolean fileValido = file.canRead();

        if (!eseguibile) {
            throw new IllegalArgumentException("non eseguibile");
        }
        if (!fileValido) {
            throw new IllegalArgumentException("non file");
        }
        return true;
    }
}
