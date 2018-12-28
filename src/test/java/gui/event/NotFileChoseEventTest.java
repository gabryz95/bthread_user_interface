package gui.event;

import gui.style.Style;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotFileChoseEventTest {

    @Test
    public void getString() {
        NotFileChoseEvent notFileChoseEvent = new NotFileChoseEvent();
        assertEquals(Style.getHour() + "[INFO]  Nessun file scelto per l'esecuzione", notFileChoseEvent.getString());
    }
}