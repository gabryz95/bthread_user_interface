package gui.event;

import org.junit.Assert;
import org.junit.Test;

public class AboutEventTest {
    private final AboutEvent aboutEvent = new AboutEvent();

    @Test
    public void getString() {
        Assert.assertEquals("About window\n", aboutEvent.getString());
    }

}