package gui.command;

import gui.controller.ProcessController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.*;

public class StartProcessCommandTest {

    private StartProcessCommand startProcessCommand;

    @Mock
    private ProcessController receiver;
    private String filename;

    @Before
    public void BeforeEachTestMethod() {
        startProcessCommand = new StartProcessCommand();
        receiver = Mockito.mock(ProcessController.class);
        filename = "/Users/gabrielezorloni/Desktop/Archive/philosophers";
    }

    @Test
    public void execute() throws IOException {
        startProcessCommand = Mockito.mock(StartProcessCommand.class);
        startProcessCommand.execute();
        Mockito.verify(startProcessCommand, Mockito.times(1)).execute();
    }

    @Test
    public void initProces01() {
        //startProcessCommand.createCommandProcess(receiver, filename);
        assertNotNull(startProcessCommand.initProcess(filename));
    }
}