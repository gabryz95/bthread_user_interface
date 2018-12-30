package gui.view;

import gui.controller.ProcessController;
import gui.mediator.CreateMediator;
import gui.mediator.MenuBarMediator;
import gui.model.*;
import gui.style.Style;
import gui.view.ganttchart.GantChartInitialize;
import gui.view.menubar.MenuBarView;
import gui.view.table.LockTableView;
import gui.view.table.MutexTable;
import gui.view.table.SemaphoreTable;
import gui.view.table.StatusTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;


public class MainWindowView {

    public GantChartInitialize gantChartInitialize;
    private static Parser parser;
    protected static MainWindowView ourInstance = new MainWindowView();
    protected static ObserverList observerList = new ObserverList();
    protected static AboutWindowView aboutWindowView;

    //tabelle
    protected static StatusTable tableView;
    public static MutexTable mutexTable;
    public static SemaphoreTable semaphoreTable;
    public static LockTableView lockTableView;

    //liste riferite alle tabelle
    private static ObservableList<Mutex> mutexList = FXCollections.observableArrayList(new ArrayList<>());
    private static ObservableList<Semaphore> semaphoreList = FXCollections.observableArrayList(new ArrayList<>());
    public static AtomicReference<List<Bthread>> bthreadList = new AtomicReference<>(new ArrayList<>());

    //TODO: creare qui OPT e passare questa ref al model
    public void showInterface(Stage primaryStage) {
        primaryStage.setTitle("Bthread Console");
        BorderPane root = new BorderPane();
        BorderPane mainContentPane = new BorderPane();
        TabPane tabContentPane = new TabPane();

        root.getStyleClass().add("main");
        //Model instance
        parser = new Parser();
        Model model = Model.create(parser, mutexList, semaphoreList);
        //Controllers
        ProcessController controller = ProcessController.create(model);

        //Gui
        ConsoleView console = ConsoleView.create();
        MenuBarView menubar = new MenuBarView(primaryStage, controller);
        SidebarView sideLeftBar = new SidebarView(primaryStage, controller);
        gantChartInitialize = GantChartInitialize.create();
        gantChartInitialize.setBthreadList(bthreadList.get());
        aboutWindowView = new AboutWindowView();
        tableView = new StatusTable();
        mutexTable = MutexTable.create(mutexList);
        semaphoreTable = SemaphoreTable.create(semaphoreList);
        lockTableView = new LockTableView();


        //Mediators
        CreateMediator createMediator = CreateMediator.create(mutexList, semaphoreList);

        MenuBarMediator menuBarMediator = MenuBarMediator.create();
        menuBarMediator.setStartProcessMenuItem(menubar.getStartProcessItemMenu());
        menuBarMediator.setPauseProcessMenuItem(menubar.getPauseItemMenu());
        menuBarMediator.setStopProcessMenuItem(menubar.getStopProcessItemMenu());
        menuBarMediator.setRestartProcessItem(menubar.getRestartItemMenu());
        menuBarMediator.setStartMonitoringMenuItem(menubar.getStartMonitoringItemMenu());
        menuBarMediator.setAboutWindow(menubar.getWindowItemMenu());

        menubar.getStartProcessItemMenu().getMenuItem().setDisable(true);
        menubar.getPauseItemMenu().getMenuItem().setDisable(true);
        menubar.getStopProcessItemMenu().getMenuItem().setDisable(true);
        menubar.getRestartItemMenu().getMenuItem().setDisable(true);
        menubar.getStartMonitoringItemMenu().getMenuItem().setDisable(true);

        Scene scene = new Scene(root, 1000, 1000);
        scene.getStylesheets().add("mainWindow.css");
        console.getConsole().appendText(Style.getHour() + "[INFO]  Bthread console started\n");

        //add children to the parents
        root.setTop(menubar.getMenu());
        root.setLeft(sideLeftBar.getSideLeftBar());
        root.setCenter(mainContentPane);

        mainContentPane.setCenter(tabContentPane);
        mainContentPane.setBottom(console.getConsole());

        //add tabs
        Tab ganttTab = new Tab("Gantt");
        Tab stateTab = new Tab("State");
        Tab barrierTab = new Tab("Barrier");
        Tab lockTab = new Tab("Lock");
        Tab mutexTab = new Tab("Mutex");
        Tab semaphoreTab = new Tab("Semaphore");
        Tab conditionTab = new Tab("Condition");

        //set tabs content
        ganttTab.setContent(gantChartInitialize.getChart());
        stateTab.setContent(tableView.getTableView());
        lockTab.setContent(lockTableView.getTableView());
        barrierTab.setContent(new AnchorPane());    //TODO: change with Barrier Table
        mutexTab.setContent(mutexTable.getTableView());
        semaphoreTab.setContent(semaphoreTable.getTableView());
        conditionTab.setContent(new AnchorPane());

        tabContentPane.getTabs().addAll(ganttTab, stateTab, barrierTab, lockTab, mutexTab, semaphoreTab, conditionTab);
        tabContentPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabContentPane.setTabMinWidth(70);

        primaryStage.setScene(scene);
        primaryStage.show();

        //observer
        //add observer to list
        parser.addObserver(createMediator);
        model.addObserver(console);
        model.addObserver(menuBarMediator);
        model.addObserver(aboutWindowView);

        //add observer to observerList
        observerList.add(console);
        observerList.add(tableView);
        observerList.add(menuBarMediator);
        observerList.add(aboutWindowView);

    }

    private MainWindowView() {
    }

    public static MainWindowView getInstance() {
        return ourInstance;
    }

    public static ObserverList getObserverList() {
        return observerList;
    }
}