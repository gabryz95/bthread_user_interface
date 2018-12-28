package gui.event;

import gui.style.Style;
import org.junit.Test;

import static org.junit.Assert.*;

public class RestartEventTest {

    private String fileName = "fileName";
    private final RestartEvent restartEvent = new RestartEvent(fileName);

    @Test
    public void getString() {
//        assertEquals(Style.getHour() + "Restart process: " + fileName, restartEvent.getString());
    }
}