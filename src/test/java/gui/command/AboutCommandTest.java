package gui.command;

import gui.controller.ProcessController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;

public class AboutCommandTest {
    private AboutCommand aboutCommand;

    @Mock
    private ProcessController receiver;
    private String filename;

    @Before
    public void BeforeEachTestMethod() {
        aboutCommand = new AboutCommand();
        receiver = Mockito.mock(ProcessController.class);
    }

    @Test
    public void execute() {
        //aboutCommand.create(receiver, filename);
        //aboutCommand.execute();
        //Mockito.verify(receiver, Mockito.times(1)).aboutWindow();
    }
}
