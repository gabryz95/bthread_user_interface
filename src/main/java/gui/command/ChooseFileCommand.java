package gui.command;

import gui.view.menubar.MenuBarView;

import java.io.File;

public class ChooseFileCommand extends CommandAbs {

    @Override
    public void execute() {
        try {
            File file = chooseFileController.getFileChooser().showOpenDialog(chooseFileController.getStage());
            if (chooseFileController.isValid(file)) {
                MenuBarView.EXECUTABLE_FILE = file.getAbsolutePath();
                chooseFileController.chooseFileProcess();
            }
        } catch (final NullPointerException e) {
            e.printStackTrace();
        }
    }
}
