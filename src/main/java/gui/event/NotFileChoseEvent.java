package gui.event;

import gui.style.Style;

public class NotFileChoseEvent {

    public NotFileChoseEvent() {
    }

    public String getString() {
        return Style.getHour() + "[INFO]  Nessun file scelto per l'esecuzione";
    }
}
