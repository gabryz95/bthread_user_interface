package gui.mediator;

import gui.command.StartProcessCommand;
import gui.controller.ProcessController;
import gui.event.StartEvent;
import gui.view.JavaFXInitTest;
import gui.view.buttonbar.SideButtonView;
import gui.view.menubar.MenuItemView;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Observable;

import static org.junit.Assert.*;

public class MenuBarMediatorTest {

    private MenuItemView startProcessMenuItem;
    private MenuItemView pauseProcessMenuItem;
    private MenuItemView stopProcessMenuItem;
    private MenuItemView startMonitoringMenuItem;
    private MenuItemView restartProcessMenuItem;
    private MenuItemView aboutWindowItem;
    private MenuItemView chooseFileMenuItem;

    private SideButtonView startProcessSideButton;
    private SideButtonView pauseProcessSideButton;
    private SideButtonView stopProcessSideButton;
    private SideButtonView restartProcessSideButton;
    private SideButtonView startMonitoringSideButton;
    private SideButtonView chooseFileSideButton;

    private MenuBarMediator menuBarMediator;

    @Before
    public void setUp() throws InterruptedException {
        JavaFXInitTest jinit = new JavaFXInitTest();
        jinit.init();

        menuBarMediator = MenuBarMediator.create();
        startProcessMenuItem = Mockito.mock(MenuItemView.class);
        pauseProcessMenuItem = Mockito.mock(MenuItemView.class);
        stopProcessMenuItem = Mockito.mock(MenuItemView.class);
        startMonitoringMenuItem = Mockito.mock(MenuItemView.class);
        restartProcessMenuItem = Mockito.mock(MenuItemView.class);
        aboutWindowItem = Mockito.mock(MenuItemView.class);
        chooseFileMenuItem = Mockito.mock(MenuItemView.class);

        startProcessSideButton = Mockito.mock(SideButtonView.class);
        pauseProcessSideButton = Mockito.mock(SideButtonView.class);
        stopProcessSideButton = Mockito.mock(SideButtonView.class);
        restartProcessSideButton = Mockito.mock(SideButtonView.class);
        startMonitoringSideButton = Mockito.mock(SideButtonView.class);
        chooseFileSideButton = Mockito.mock(SideButtonView.class);

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
    public void setChooseFileMenuItem() {
        menuBarMediator.setChooseFileMenuItem(chooseFileMenuItem);
        assertEquals(menuBarMediator.chooseFileMenuItem, chooseFileMenuItem);
    }

    @Test
    public void setStartProcessSideButton() {
        menuBarMediator.setStartProcessSideButton(startProcessSideButton);
        assertEquals(menuBarMediator.startProcessSideButton, startProcessSideButton);
    }

    @Test
    public void setPauseProcessSideButton() {
        menuBarMediator.setPauseProcessSideButton(pauseProcessSideButton);
        assertEquals(menuBarMediator.pauseProcessSideButton, pauseProcessSideButton);
    }

    @Test
    public void setStopProcessSideButton() {
        menuBarMediator.setStopProcessSideButton(stopProcessSideButton);
        assertEquals(menuBarMediator.stopProcessSideButton, stopProcessSideButton);
    }

    @Test
    public void setRestartProcessSideButton() {
        menuBarMediator.setRestartProcessSideButton(restartProcessSideButton);
        assertEquals(menuBarMediator.restartProcessSideButton, restartProcessSideButton);
    }

    @Test
    public void setStartMonitoringSideButton() {
        menuBarMediator.setStartMonitoringSideButton(startMonitoringSideButton);
        assertEquals(menuBarMediator.startMonitoringSideButton, startMonitoringSideButton);
    }

    @Test
    public void setChooseFileSideButton() {
        menuBarMediator.setChooseFileSideButton(chooseFileSideButton);
        assertEquals(menuBarMediator.chooseFileSideButton, chooseFileSideButton);
    }


    @Ignore
    @Test
    public void itemSetting() {
//        Observable observable = Mockito.mock(Observable.class);
//        StartEvent startEvent = Mockito.mock(StartEvent.class);
//        MenuItemView startProcessMenuItem = MenuItemView.create("Start", Mockito.mock(StartProcessCommand.class),
//                Mockito.mock(ProcessController.class));
//        menuBarMediator.setStartProcessMenuItem(startProcessMenuItem);
//        menuBarMediator.setPauseProcessMenuItem(pauseProcessMenuItem);
//        menuBarMediator.update(observable, startEvent);
    }

    @Test
    public void update() {
    }
}