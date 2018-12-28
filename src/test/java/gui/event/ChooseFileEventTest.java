package gui.event;

import gui.style.Style;
import gui.view.menubar.MenuBarView;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChooseFileEventTest {

    private final ChooseFileEvent chooseFileEvent = new ChooseFileEvent();

    @Test
    public void getString() {
        assertEquals(Style.getHour()+"[INFO]  File scelto per l'esecuzione: " + MenuBarView.EXECUTABLE_FILE, chooseFileEvent.getString());
    }
}