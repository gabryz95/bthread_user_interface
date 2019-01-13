package gui.event;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;

class NotPauseEventTest {

    private NotPauseEvent notPauseEvent;
    private String filename = " ";

    @BeforeEach
    public void setUp() {
        notPauseEvent = new NotPauseEvent(filename);
    }

    @Test
    public void getString() {
        assertEquals("Not Pause process: " +filename, notPauseEvent.getString());
    }
}