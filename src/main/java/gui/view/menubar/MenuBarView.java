package gui.view.menubar;

import gui.command.*;
import gui.controller.AboutWindowController;
import gui.controller.ChooseFileController;
import gui.controller.ExitController;
import gui.controller.ProcessController;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class MenuBarView {

    public static String EXECUTABLE_FILE = null;

    protected MenuItemView startItemMenu;
    protected MenuItemView pauseItemMenu;
    protected MenuItemView stopItemMenu;
    protected MenuItemView startMonitoringItemMenu;
    protected MenuItemView restartItemMenu;
    protected MenuItemView aboutItemMenu;
    protected MenuItemView chooseFileItemMenu;
    protected MenuBar menuBar;

    public static MenuBarView create(final ProcessController controller, final AboutWindowController aboutWindowController, final ExitController exitController,
                                     final ChooseFileController chooseFileController) {

        MenuBarView menuBarView = new MenuBarView();
        menuBarView.menuBar = new MenuBar();

        //FILE MENU
        MenuItem newMenu = new MenuItem("New");
        menuBarView.chooseFileItemMenu = MenuItemView.create("Open File", new ChooseFileCommand(), chooseFileController);
        MenuItemView exitItemMenu = MenuItemsViewFactory.instance().createMenuItem("Exit", new ExitCommand(), exitController);

        Menu fileMenu = MenuFactory.instance().createMenu("File");
        fileMenu.getItems().addAll(newMenu, menuBarView.chooseFileItemMenu.getMenuItem(), exitItemMenu.getMenuItem());
        //THREAD MENU

        menuBarView.startItemMenu = MenuItemsViewFactory.instance().createMenuItem("Start", new StartProcessCommand(), controller);
        menuBarView.pauseItemMenu = MenuItemsViewFactory.instance().createMenuItem("Pause", new PauseProcessCommand(), controller);
        menuBarView.startMonitoringItemMenu = MenuItemsViewFactory.instance().createMenuItem("Monitoring", new StartMonitoringCommand(), controller);
        menuBarView.stopItemMenu = MenuItemsViewFactory.instance().createMenuItem("Stop", new StopProcessCommand(), controller);
        menuBarView.restartItemMenu = MenuItemsViewFactory.instance().createMenuItem("Restart", new RestartProcessCommand(), controller);

        SeparatorMenuItem separatorMenuItem1 = new SeparatorMenuItem();
        SeparatorMenuItem separatorMenuItem2 = new SeparatorMenuItem();

        Menu threadMenu = MenuFactory.instance().createMenu("Thread");
        threadMenu.getItems().addAll(menuBarView.startItemMenu.getMenuItem(), menuBarView.pauseItemMenu.getMenuItem(), menuBarView.stopItemMenu.getMenuItem(),
                separatorMenuItem1, menuBarView.restartItemMenu.getMenuItem(), separatorMenuItem2, menuBarView.startMonitoringItemMenu.getMenuItem());

        //HELP MENU
        menuBarView.aboutItemMenu = MenuItemsViewFactory.instance().createMenuItem("About", new AboutCommand(), aboutWindowController);
        Menu helpMenu = new Menu("Help");
        helpMenu.getItems().addAll(menuBarView.aboutItemMenu.getMenuItem());


        menuBarView.menuBar.getMenus().addAll(fileMenu, threadMenu, helpMenu);
        return menuBarView;
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

    public MenuItemView getWindowItemMenu() {
        return aboutItemMenu;
    }

    public MenuItemView getChooseFileItemMenu() {
        return chooseFileItemMenu;
    }
}
