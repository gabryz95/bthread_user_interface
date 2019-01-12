package gui.command;

import gui.controller.ProcessController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertNull;


public class StopProcessCommandTest {

    private StopProcessCommand stopProcessCommand;

    @Mock
    private ProcessController receiver;
    private String filename;


    @Before
    public void BeforeEachTestMethod() {
        stopProcessCommand = new StopProcessCommand();
        receiver = Mockito.mock(ProcessController.class);
        filename = "/Users/gabrielezorloni/Desktop/Archive/philosophers";
    }

//    @Test
//    public void execute() {
//        stopProcessCommand.createCommandProcess(receiver, filename);
//        stopProcessCommand.execute();
//        Mockito.verify(receiver, Mockito.times(1)).stopProcess(stopProcessCommand.stopProcess(), filename);
//    }
//
//    @Test
//    public void stopProcess01() {
//        stopProcessCommand.createCommandProcess(receiver, filename);
//        assertNull(stopProcessCommand.stopProcess());
//    }

    @Test
    public void stopProcess02() {
        stopProcessCommand = Mockito.mock(StopProcessCommand.class);
        stopProcessCommand.stopProcess();
        Mockito.verify(stopProcessCommand, Mockito.times(1)).stopProcess();
    }
}