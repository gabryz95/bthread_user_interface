package gui.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class OutputProcessingThreadTest {

    private Process process;
    private Parser parser;
    private ObserverList observableList;
    private OutputProcessingThread outputProcessingThread;

    @BeforeEach
    public void setUp() {
        process = Mockito.mock(Process.class);
        parser = Mockito.mock(Parser.class);
        observableList = Mockito.mock(ObserverList.class);
        outputProcessingThread = OutputProcessingThread.create(process, observableList, parser);
    }

    @Test
    public void create01() {
        assertNull(OutputProcessingThread.create(null, observableList, parser));
    }

    @Test
    public void create02() {
        assertNull(OutputProcessingThread.create(process, null, parser));
    }

    @Test
    public void create03() {
        assertNull(OutputProcessingThread.create(process, observableList, null));
    }

    @Test
    public void create04() {
        assertNotNull(outputProcessingThread);
    }

    @Test
    public void setIsMonitoring() {
        outputProcessingThread.setIsMonitoring(true);
        assertTrue(outputProcessingThread.isMonitoring.get());
    }
}