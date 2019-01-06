package gui.event;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;

class NotPauseEventTest {

    private NotPauseEvent notPauseEvent;

    @BeforeEach
    public void setUp() {
        notPauseEvent = new NotPauseEvent(any(String.class));
    }

    @Test
    public void getString() {
        assertEquals("Not Pause process: " + any(String.class), notPauseEvent.getString());
    }
}