package gui.view.menubar;

import gui.command.*;
import gui.controller.AboutWindowController;
import gui.controller.ChooseFileController;
import gui.controller.ExitController;
import gui.controller.ProcessController;
import gui.view.MainWindowView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class MenuBarView {

    public static String EXECUTABLE_FILE = null;
    protected MenuItemView startItemMenu;
    protected MenuItemView pauseItemMenu;
    protected MenuItemView stopItemMenu;
    protected MenuItemView startMonitoringItemMenu;
    protected MenuItemView restartItemMenu;
    protected MenuItemView aboutItemMenu;
    protected MenuBar menuBar;

    public MenuBarView(final Stage stage, final ProcessController controller) {
        menuBar = new MenuBar();

        Menu fileMenu = new Menu("File");
        MenuItem newMenu = new MenuItem("New");
        MenuItem chooseFileMenu = new MenuItem("Open File");
        chooseFileMenu.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_ANY));
        MenuItem exitMenu = new MenuItem("Exit");
        exitMenu.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_ANY));
        fileMenu.getItems().addAll(newMenu, chooseFileMenu, exitMenu);

        Menu threadMenu = new Menu("Thread");
        this.startItemMenu = new MenuItemView("Start", new StartProcessCommand(), controller, MainWindowView.getObserverList());
        this.pauseItemMenu = new MenuItemView("Pause", new PauseProcessCommand(), controller, MainWindowView.getObserverList());
        this.startMonitoringItemMenu = new MenuItemView("Monitoring", new StartMonitoringCommand(), controller, MainWindowView.getObserverList());
        this.stopItemMenu = new MenuItemView("Stop", new StopProcessCommand(), controller, MainWindowView.getObserverList());
        SeparatorMenuItem separatorMenuItem1 = new SeparatorMenuItem();
        this.restartItemMenu = new MenuItemView("Restart", new RestartProcessCommand(), controller, MainWindowView.getObserverList());
        SeparatorMenuItem separatorMenuItem2 = new SeparatorMenuItem();
        threadMenu.getItems().addAll(startItemMenu.getMenuItem(), pauseItemMenu.getMenuItem(), stopItemMenu.getMenuItem(), separatorMenuItem1,
                restartItemMenu.getMenuItem(), separatorMenuItem2, startMonitoringItemMenu.getMenuItem());

        Menu helpMenu = new Menu("Help");
        MenuItem aboutMenu = new MenuItem("About");
        helpMenu.getItems().add(aboutMenu);
        this.aboutItemMenu = new MenuItemView("About", new AboutCommand(), controller, MainWindowView.getObserverList());

        menuBar.getMenus().addAll(fileMenu, threadMenu, helpMenu);

        final AboutWindowController aboutWindowController = new AboutWindowController(stage, controller);
        aboutMenu.setOnAction(e -> aboutWindowController.execute());


        final ExitController exitController = new ExitController(stage, controller);
        exitMenu.setOnAction(e -> exitController.execute());

        final ChooseFileController chooseFileController = new ChooseFileController(stage, controller);
        chooseFileMenu.setOnAction(e -> chooseFileController.execute());
    }

    public MenuBar getMenu() {
        return menuBar;
    }

    public MenuItemView getStartProcessItemMenu() {
        return startItemMenu;
    }

    public MenuItemView getStopProcessItemMenu() {
        return stopItemMenu;
    }

    public MenuItemView getStartMonitoringItemMenu() {
        return startMonitoringItemMenu;
    }

    public MenuItemView getRestartItemMenu() {
        return restartItemMenu;
    }

    public MenuItemView getPauseItemMenu() {
        return pauseItemMenu;
    }

    public MenuItemView getWindowItemMenu() { return aboutItemMenu; }

}
