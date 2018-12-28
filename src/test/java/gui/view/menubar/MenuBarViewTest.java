package gui.view.menubar;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;


public class MenuBarViewTest {

    @Test
    public void getMenu() {
        MenuBarView menuBarView = Mockito.mock(MenuBarView.class);
        assertEquals(menuBarView.menuBar, menuBarView.getMenu());
    }

    @Test
    public void getStartProcessItem() {
        MenuBarView menuBarView = Mockito.mock(MenuBarView.class);
        assertEquals(menuBarView.startItemMenu, menuBarView.getStartProcessItemMenu());
    }

    @Test
    public void getStopProcessItem() {
        MenuBarView menuBarView = Mockito.mock(MenuBarView.class);
        assertEquals(menuBarView.stopItemMenu, menuBarView.getStopProcessItemMenu());
    }

    @Test
    public void getStartMonitoringItem() {
        MenuBarView menuBarView = Mockito.mock(MenuBarView.class);
        assertEquals(menuBarView.startMonitoringItemMenu, menuBarView.getStartMonitoringItemMenu());
    }

    @Test
    public void getRestartItem() {
        MenuBarView menuBarView = Mockito.mock(MenuBarView.class);
        assertEquals(menuBarView.restartItemMenu, menuBarView.getRestartItemMenu());
    }

    @Test
    public void getPauseItem() {
        MenuBarView menuBarView = Mockito.mock(MenuBarView.class);
        assertEquals(menuBarView.pauseItemMenu, menuBarView.getPauseItemMenu());
    }

    @Test
    public void getWindowItemMenu() {
        MenuBarView menuBarView = Mockito.mock(MenuBarView.class);
        assertEquals(menuBarView.aboutItemMenu, menuBarView.getWindowItemMenu());
    }
}