package gui.interfaces;

import gui.controller.ProcessController;
import gui.event.NotFileChoseEvent;

import java.util.Observable;

//TOGLIERE L'OBSERVABLE
public abstract class CommandAbs extends Observable implements Command {
    protected ProcessController receiver;
    protected String filename;

    @Override
    public Command create(ProcessController receiver, String filename) {

        if (receiver == null)
            return null;

        if (filename == null || filename.isEmpty()) {
            this.setChanged();
            this.notifyObservers(new NotFileChoseEvent());
            return null;
        }

        this.receiver = receiver;
        this.filename = filename;

        return this;
    }
}
