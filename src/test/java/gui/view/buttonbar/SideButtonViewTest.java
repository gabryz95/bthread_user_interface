package gui.view.buttonbar;

import gui.command.ChooseFileCommand;
import gui.command.StartProcessCommand;
import gui.controller.ChooseFileController;
import gui.controller.ProcessController;
import gui.view.JavaFXInitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class SideButtonViewTest {

    private SideButtonView sideButtonView;
    @Mock
    private StartProcessCommand startProcessCommand;
    @Mock
    private ChooseFileCommand chooseFileCommand;
    @Mock
    private ProcessController processController;
    @Mock
    private ChooseFileController chooseFileController;
    private String filename;

    @BeforeEach
    public void setUp() throws InterruptedException {
        JavaFXInitTest jinit = new JavaFXInitTest();
        jinit.init();
        startProcessCommand = Mockito.mock(StartProcessCommand.class);
        chooseFileCommand = Mockito.mock(ChooseFileCommand.class);
        processController = Mockito.mock(ProcessController.class);
        chooseFileController = Mockito.mock(ChooseFileController.class);
        sideButtonView = SideButtonView.create("openBtn", startProcessCommand, processController);
    }

    @Test
    public void create01() {
        assertNull(SideButtonView.create(null, startProcessCommand, processController));
    }

    @Test
    public void create02() {
        assertNull(SideButtonView.create("openBtn", null, processController));
    }

    @Test
    public void create03() {
        assertNull(SideButtonView.create("openBtn", startProcessCommand, null));
    }

    @Test
    public void create04() {
        assertNotNull(sideButtonView);
    }

    @Test
    public void getSideButton() {
        assertEquals(sideButtonView.button, sideButtonView.getSideButton());
    }

    @Test
    public void createCommand01() {
        sideButtonView.createCommand(processController, startProcessCommand);
        Mockito.verify(startProcessCommand, Mockito.times(1)).createCommandProcess(processController, null);
    }

    @Test
    public void createCommand02() {
        sideButtonView.createCommand(chooseFileController, chooseFileCommand);
        Mockito.verify(chooseFileCommand, Mockito.times(1)).createChooseFileCommand(chooseFileController);
    }
}