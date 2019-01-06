package gui.command;

import gui.controller.AboutWindowController;
import gui.controller.ChooseFileController;
import gui.controller.ExitController;
import gui.controller.ProcessController;
import gui.interfaces.Command;
import gui.interfaces.Controller;

public abstract class CommandAbs extends Controller implements Command {

    protected ProcessController receiver;
    protected AboutWindowController aboutWindowController;
    protected ExitController exitController;
    protected ChooseFileController chooseFileController;
    protected String filename;

    @Override
    public Command createCommandProcess(Controller receiver, String filename) {

        if (receiver == null)
            return null;

        if (filename == null || filename.isEmpty())
            return null;

        this.receiver = (ProcessController) receiver;
        this.filename = filename;
        return this;
    }

    @Override
    public Command createAboutCommand(Controller controller) {

        if (controller == null)
            return null;

        this.aboutWindowController = (AboutWindowController) controller;
        return this;
    }

    @Override
    public Command createExitCommand(Controller controller) {
        if (controller == null)
            return null;

        this.exitController = (ExitController) controller;
        return this;
    }

    @Override
    public Command createChooseFileCommand(Controller controller) {
        if (controller == null)
            return null;

        this.chooseFileController = (ChooseFileController) controller;
        return this;
    }
}
