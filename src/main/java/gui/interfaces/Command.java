package gui.interfaces;

import gui.controller.ProcessController;

import java.io.IOException;

public interface Command {

    Command createCommandProcess(Controller receiver, String filename);

    Command createAboutCommand(Controller controller);

    Command createExitCommand(Controller controller);

    Command createChooseFileCommand(Controller controller);

    void execute() throws IOException;
}
