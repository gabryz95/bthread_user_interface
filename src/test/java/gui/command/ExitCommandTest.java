package gui.command;

import gui.controller.ExitController;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class ExitCommandTest {

    private ExitCommand exitCommand;

    @Mock
    private ExitController exitController;

    @BeforeEach
    public void setUp() {
        exitCommand = new ExitCommand();
        exitController = Mockito.mock(ExitController.class);
        exitController.setStage(Mockito.mock(Stage.class));
    }

    @Test
    public void execute() {
        exitCommand.createExitCommand(exitController);
//        exitCommand.execute();
//        Mockito.verify(exitController, Mockito.times(1)).exitProcess();
    }
}