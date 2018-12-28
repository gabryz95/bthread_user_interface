package gui.mediator;

import gui.event.*;
import gui.view.menubar.MenuItemView;

import java.util.Observable;
import java.util.Observer;

public class MenuBarMediator implements Observer {

    protected MenuItemView startProcessMenuItem;
    protected MenuItemView pauseProcessMenuItem;
    protected MenuItemView stopProcessMenuItem;
    protected MenuItemView restartProcessItem;
    protected MenuItemView startMonitoringMenuItem;
    protected MenuItemView aboutWindow;

    protected MenuBarMediator() {
    }

    public static MenuBarMediator create() {
        MenuBarMediator menuBarMediator = new MenuBarMediator();
        return menuBarMediator;
    }

    public void setStartProcessMenuItem(MenuItemView startProcessMenuItem) {
        this.startProcessMenuItem = startProcessMenuItem;
    }

    public void setPauseProcessMenuItem(MenuItemView pauseProcessMenuItem) {
        this.pauseProcessMenuItem = pauseProcessMenuItem;
    }

    public void setStopProcessMenuItem(MenuItemView stopProcessMenuItem) {
        this.stopProcessMenuItem = stopProcessMenuItem;
    }

    public void setStartMonitoringMenuItem(MenuItemView startMonitoringMenuItem) {
        this.startMonitoringMenuItem = startMonitoringMenuItem;
    }

    public void setAboutWindow(MenuItemView aboutWindow) {
        this.aboutWindow = aboutWindow;
    }

    public void setRestartProcessItem(MenuItemView restartProcessItem) {
        this.restartProcessItem = restartProcessItem;
    }

    private void menuItemSetDisable(MenuItemView restartProcessItem, MenuItemView startMonitoringMenuItem) {
        startProcessMenuItem.getMenuItem().setDisable(true);
        pauseProcessMenuItem.getMenuItem().setDisable(false);
        stopProcessMenuItem.getMenuItem().setDisable(false);
        restartProcessItem.getMenuItem().setDisable(false);
        startMonitoringMenuItem.getMenuItem().setDisable(false);
    }

    @Override
    public void update(Observable o, Object event) {
        if (event instanceof StartEvent) {
            menuItemSetDisable(restartProcessItem, startMonitoringMenuItem);
        } else if (event instanceof StopEvent) {
            startProcessMenuItem.getMenuItem().setDisable(false);
            pauseProcessMenuItem.getMenuItem().setDisable(true);
            stopProcessMenuItem.getMenuItem().setDisable(true);
            restartProcessItem.getMenuItem().setDisable(true);
            startMonitoringMenuItem.getMenuItem().setDisable(true);
        } else if (event instanceof MonitoringStartedEvent) {
            startProcessMenuItem.getMenuItem().setDisable(true);
            pauseProcessMenuItem.getMenuItem().setDisable(false);
            stopProcessMenuItem.getMenuItem().setDisable(false);
            restartProcessItem.getMenuItem().setDisable(false);
            startMonitoringMenuItem.getMenuItem().setDisable(true);
        } else if (event instanceof PauseEvent) {
            startProcessMenuItem.getMenuItem().setDisable(true);
            pauseProcessMenuItem.getMenuItem().setDisable(false);
            stopProcessMenuItem.getMenuItem().setDisable(false);
            startMonitoringMenuItem.getMenuItem().setDisable(true);
            restartProcessItem.getMenuItem().setDisable(false);
        } else if (event instanceof RestartEvent) {
            menuItemSetDisable(startMonitoringMenuItem, restartProcessItem);
        } else if (event instanceof ChooseFileEvent) {
            startProcessMenuItem.getMenuItem().setDisable(false);
        }
    }
}

