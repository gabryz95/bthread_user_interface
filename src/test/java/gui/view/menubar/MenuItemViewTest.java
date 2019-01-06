package gui.view.menubar;

import gui.command.AboutCommand;
import gui.command.ChooseFileCommand;
import gui.command.ExitCommand;
import gui.command.StartProcessCommand;
import gui.controller.AboutWindowController;
import gui.controller.ChooseFileController;
import gui.controller.ExitController;
import gui.controller.ProcessController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class MenuItemViewTest {

    private MenuItemView menuItemView;
    @Mock
    private StartProcessCommand startProcessCommand;
    @Mock
    private ProcessController processController;

    @BeforeEach
    public void setUp() {
        startProcessCommand = Mockito.mock(StartProcessCommand.class);
        processController = Mockito.mock(ProcessController.class);
        menuItemView = MenuItemView.create("Start", startProcessCommand, processController);
    }

    @Test
    public void create01() {
        assertNull(MenuItemView.create(null, startProcessCommand, processController));
    }

    @Test
    public void create02() {
        assertNull(MenuItemView.create("Start", null, processController));
    }

    @Test
    public void create03() {
        assertNull(MenuItemView.create("Start", startProcessCommand, null));
    }

    @Test
    public void create04() {
        assertNotNull(menuItemView);
    }

    @Test
    public void getMenuItem() {
        assertEquals(menuItemView.menuItem, menuItemView.getMenuItem());
    }

    @Test
    public void createCommand01() {
        menuItemView.createCommand(processController, startProcessCommand);
        Mockito.verify(startProcessCommand, Mockito.times(1)).createCommandProcess(processController, null);
    }

    @Test
    public void createCommand02() {
        AboutCommand aboutCommand = Mockito.mock(AboutCommand.class);
        AboutWindowController aboutWindowController = Mockito.mock(AboutWindowController.class);
        MenuItemView menuItemView1 = MenuItemView.create("About", aboutCommand, aboutWindowController);
        menuItemView1.createCommand(aboutWindowController, aboutCommand);
        Mockito.verify(aboutCommand, Mockito.times(1)).createAboutCommand(aboutWindowController);
    }

    @Test
    public void createCommand03() {
        ExitCommand exitCommand = Mockito.mock(ExitCommand.class);
        ExitController exitController = Mockito.mock(ExitController.class);
        MenuItemView menuItemView1 = MenuItemView.create("Exit", exitCommand, exitController);
        menuItemView1.createCommand(exitController, exitCommand);
        Mockito.verify(exitCommand, Mockito.times(1)).createExitCommand(exitController);
    }

    @Test
    public void createCommand04() {
        ChooseFileCommand chooseFileCommand = Mockito.mock(ChooseFileCommand.class);
        ChooseFileController chooseFileController = Mockito.mock(ChooseFileController.class);
        MenuItemView menuItemView1 = MenuItemView.create("Choose File", chooseFileCommand, chooseFileController);
        menuItemView1.createCommand(chooseFileController, chooseFileCommand);
        Mockito.verify(chooseFileCommand, Mockito.times(1)).createChooseFileCommand(chooseFileController);
    }

}