package gui.command;

import gui.controller.ProcessController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Matchers.anyString;


public class PauseProcessCommandTest {

    private PauseProcessCommand pauseProcessCommand;

    @Mock
    private ProcessController receiver;
    private String filename;

    @Before
    public void BeforeEachTestMethod() {
        pauseProcessCommand = new PauseProcessCommand();
        receiver = Mockito.mock(ProcessController.class);
        filename = "nomefile";
    }

    @Test
    public void execute() {
        pauseProcessCommand.create(receiver, filename);
        pauseProcessCommand.execute();
        //TODO: da sistemare
        //Mockito.verify(receiver, Mockito.times(1)).pauseProcess(anyString());
    }
}