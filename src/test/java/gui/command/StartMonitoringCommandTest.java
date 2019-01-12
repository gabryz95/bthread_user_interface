package gui.command;


import gui.controller.ProcessController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Matchers.any;


public class StartMonitoringCommandTest {

    private StartMonitoringCommand startMonitoringCommand;

    @Mock
    private ProcessController receiver;
    private String filename;

    @Before
    public void BeforeEachTestMethod() {
        startMonitoringCommand = new StartMonitoringCommand();
        receiver = Mockito.mock(ProcessController.class);
        filename = "nomefile";
    }

    @Test
    public void execute() {
        //startMonitoringCommand.createCommandProcess(receiver, filename);
        startMonitoringCommand.execute();
        Mockito.verify(receiver, Mockito.times(1)).startMonitoring(any(Process.class));
    }
}