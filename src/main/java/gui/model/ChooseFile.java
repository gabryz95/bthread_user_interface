package gui.model;

import gui.event.ChooseFileEvent;
import gui.interfaces.ChooserFileManager;

import java.util.Observable;

public class ChooseFile extends Observable implements ChooserFileManager {

    @Override
    public void chooseFileProcess() {
        this.setChanged();
        this.notifyObservers(new ChooseFileEvent());
    }
}
