package gui.command;


import gui.controller.ProcessController;
import gui.singleton.MainProcess;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;

public class RestartProcessCommandTest {


    private RestartProcessCommand restartProcessCommand;

    @Mock
    private ProcessController receiver;
    private String filename;

    @Before
    public void BeforeEachTestMethod() {
        restartProcessCommand = new RestartProcessCommand();
        receiver = Mockito.mock(ProcessController.class);
        filename = "/Users/gabrielezorloni/Desktop/Archive/philosophers";
    }

    //controllo che i parametri che gli passo non siano null se non si rompe tutto
    @Test
    public void execute() {
        MainProcess mainProcess = Mockito.mock(MainProcess.class);
        restartProcessCommand.create(receiver, filename);
        restartProcessCommand.execute();
        //Mockito.verify(receiver, Mockito.times(1)).restartProcess(any(Process.class), restartProcessCommand.initProcess(filename));

    }

    @Test
    public void initProces01() {
        restartProcessCommand.create(receiver, filename);
        assertNotNull(restartProcessCommand.initProcess(filename));
    }
}