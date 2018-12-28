package gui.event;

import gui.style.Style;
import gui.view.menubar.MenuBarView;

public class ChooseFileEvent {
    public String getString() {
        return Style.getHour()+"[INFO]  File scelto per l'esecuzione: " + MenuBarView.EXECUTABLE_FILE;
    }
}
