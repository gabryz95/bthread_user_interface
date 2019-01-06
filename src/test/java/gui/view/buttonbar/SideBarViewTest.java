package gui.view.buttonbar;

import gui.controller.ChooseFileController;
import gui.controller.ProcessController;
import gui.view.JavaFXInitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class SideBarViewTest {

    private SideBarView sideBarView;
    @Mock
    private ProcessController processController;
    @Mock
    private ChooseFileController chooseFileController;

    @BeforeEach
    public void setUp() throws InterruptedException {
        JavaFXInitTest jinit = new JavaFXInitTest();
        jinit.init();
        processController = Mockito.mock(ProcessController.class);
        chooseFileController = Mockito.mock(ChooseFileController.class);
        sideBarView = SideBarView.create(processController, chooseFileController);
    }

    @Test
    public void create01() {
        assertNull(SideBarView.create(null, chooseFileController));
    }

    @Test
    public void create02() {
        assertNull(SideBarView.create(processController, null));
    }

    @Test
    public void create03() {
        assertNotNull(sideBarView);
    }

    @Test
    public void getSideLeftBar() {
        assertEquals(sideBarView.sideLeftBar, sideBarView.getSideLeftBar());
    }

    @Test
    public void getOpenBtn() {
        assertEquals(sideBarView.openBtn, sideBarView.getOpenBtn());
    }

    @Test
    public void getStartBtn() {
        assertEquals(sideBarView.startBtn, sideBarView.getStartBtn());
    }

    @Test
    public void getStopBtn() {
        assertEquals(sideBarView.stopBtn, sideBarView.getStopBtn());
    }

    @Test
    public void getPauseBtn() {
        assertEquals(sideBarView.pauseBtn, sideBarView.getPauseBtn());
    }

    @Test
    public void getRestartBtn() {
        assertEquals(sideBarView.restartBtn, sideBarView.getRestartBtn());
    }

    @Test
    public void getMonitoringBtn() {
        assertEquals(sideBarView.monitoringBtn, sideBarView.getMonitoringBtn());
    }
}