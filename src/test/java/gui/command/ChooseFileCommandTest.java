package gui.command;

import gui.controller.ChooseFileController;
import gui.view.JavaFXInitTest;
import gui.view.menubar.MenuItemView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class ChooseFileCommandTest {

    @Mock
    private ChooseFileController chooseFileController;
    private ChooseFileCommand chooseFileCommand;

    @BeforeEach
    public void setUp() throws InterruptedException {
//        JavaFXInitTest jinit = new JavaFXInitTest();
//        jinit.init();
        chooseFileController = Mockito.mock(ChooseFileController.class);
        chooseFileCommand = new ChooseFileCommand();
    }

    @Test
    public void execute01() {
        chooseFileCommand.createChooseFileCommand(chooseFileController);
//        chooseFileCommand.execute();
//        Mockito.verify(chooseFileController, Mockito.times(1)).chooseFileProcess();
    }


}