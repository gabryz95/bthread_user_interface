package gui.mediator;

import gui.view.menubar.MenuItemView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class MenuBarMediatorTest {

    @Mock
    private MenuItemView startProcessMenuItem;
    @Mock
    private MenuItemView pauseProcessMenuItem;
    @Mock
    private MenuItemView stopProcessMenuItem;
    @Mock
    private MenuItemView startMonitoringMenuItem;
    @Mock
    private MenuItemView restartProcessMenuItem;
    @Mock
    private MenuItemView aboutWindowItem;

    private MenuBarMediator menuBarMediator;

    @Before
    public void setUp() {
        menuBarMediator = MenuBarMediator.create();
        startProcessMenuItem = Mockito.mock(MenuItemView.class);
        pauseProcessMenuItem = Mockito.mock(MenuItemView.class);
        stopProcessMenuItem = Mockito.mock(MenuItemView.class);
        startMonitoringMenuItem = Mockito.mock(MenuItemView.class);
        restartProcessMenuItem = Mockito.mock(MenuItemView.class);
        aboutWindowItem = Mockito.mock(MenuItemView.class);
    }

    @Test
    public void create() {
        assertNotNull(menuBarMediator);
    }

    @Test
    public void setStartProcessMenuItem() {
        menuBarMediator.setStartProcessMenuItem(startProcessMenuItem);
        assertEquals(menuBarMediator.startProcessMenuItem, startProcessMenuItem);

    }

    @Test
    public void setPauseProcessMenuItem() {
        menuBarMediator.setPauseProcessMenuItem(pauseProcessMenuItem);
        assertEquals(menuBarMediator.pauseProcessMenuItem, pauseProcessMenuItem);

    }

    @Test
    public void setStopProcessMenuItem() {
        menuBarMediator.setStopProcessMenuItem(stopProcessMenuItem);
        assertEquals(menuBarMediator.stopProcessMenuItem, stopProcessMenuItem);
    }

    @Test
    public void setStartMonitoringMenuItem() {
        menuBarMediator.setStartMonitoringMenuItem(startMonitoringMenuItem);
        assertEquals(menuBarMediator.startMonitoringMenuItem, startMonitoringMenuItem);
    }

    @Test
    public void setRestartProcessItem() {
        menuBarMediator.setRestartProcessItem(restartProcessMenuItem);
        assertEquals(menuBarMediator.restartProcessItem, restartProcessMenuItem);
    }

    @Test
    public void setAboutWindow() {
        menuBarMediator.setRestartProcessItem(aboutWindowItem);
        assertEquals(menuBarMediator.restartProcessItem, aboutWindowItem);
    }

    @Test
    public void update() {
    }
}