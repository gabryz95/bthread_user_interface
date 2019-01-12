package gui.command;

import gui.controller.AboutWindowController;
import gui.controller.ProcessController;
import gui.view.JavaFXInitTest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;

public class AboutCommandTest {
    private AboutCommand aboutCommand;

    @Mock
    private AboutWindowController receiver;

    @Before
    public void BeforeEachTestMethod() {
        //aboutCommand = new AboutCommand();
        receiver = Mockito.mock(AboutWindowController.class);
    }

    @Test
    public void execute() {
        //aboutCommand.createAboutCommand(receiver);
        aboutCommand.execute();
        Mockito.verify(receiver, Mockito.times(1)).aboutWindow();
    }
}
