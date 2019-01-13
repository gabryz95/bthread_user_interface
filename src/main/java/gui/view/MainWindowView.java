package gui.view;

import gui.controller.AboutWindowController;
import gui.controller.ChooseFileController;
import gui.controller.ExitController;
import gui.controller.ProcessController;
import gui.mediator.CreateMediator;
import gui.mediator.MenuBarMediator;
import gui.model.*;
import gui.model.date.*;
import gui.model.date.datemodel.*;
import gui.style.Style;
import gui.view.buttonbar.SideBarView;
import gui.view.console.ConsoleAbstract;
import gui.view.console.ConsoleView;
import gui.view.ganttchart.GantChartInitialize;
import gui.view.menubar.MenuBarView;
import gui.view.table.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MainWindowView {

    public static ExecutableFile executableFile = new ExecutableFile();

    public GantChartInitialize gantChartInitialize;
    private static Parser parser;
    protected static MainWindowView ourInstance = new MainWindowView();
    protected static ObserverList observerList = new ObserverList();
    protected static AboutWindowView aboutWindowView;

    //tabelle
    public static StatusTable tableView;
    public static MutexTable mutexTable;
    public static SemaphoreTable semaphoreTable;
    public static LockTable lockTable;
    public static BarrierTable barrierTable;
    public static ConditionTable conditionTable;

    //liste riferite alle tabelle
    private static ObservableList<Status> statusList = FXCollections.observableArrayList(new ArrayList<>());
    private static ObservableList<Lock> lockList = FXCollections.observableArrayList(new ArrayList<>());
    private static ObservableList<Mutex> mutexList = FXCollections.observableArrayList(new ArrayList<>());
    private static ObservableList<Semaphore> semaphoreList = FXCollections.observableArrayList(new ArrayList<>());
    private static ObservableList<Barrier> barrierList = FXCollections.observableArrayList(new ArrayList<>());
    private static ObservableList<Condition> conditionList = FXCollections.observableArrayList(new ArrayList<>());
    public static AtomicReference<List<Bthread>> bthreadList = new AtomicReference<>(new ArrayList<>());


    //TODO: creare qui OPT e passare questa ref al model
    public void showInterface(Stage primaryStage) {
        primaryStage.setTitle("Bthread Console");
        BorderPane root = new BorderPane();
        BorderPane mainContentPane = new BorderPane();
        TabPane tabContentPane = new TabPane();

        root.getStyleClass().add("main");

        //Parser instance
        parser = new Parser();
        Model model = Model.create(parser, statusList, lockList, mutexList, semaphoreList, barrierList, conditionList);

        //Model instance
        AboutWindow aboutWindow = new AboutWindow();
        Exit exit = new Exit();
        ChooseFile chooseFile = new ChooseFile();

        //
        StatusModel statusModel = StatusModel.create(statusList);
        LockModel lockModel = LockModel.create(lockList);
        MutexModel mutexModel = MutexModel.create(mutexList);
        BarrierModel barrierModel = BarrierModel.create(barrierList);
        SemaphoreModel semaphoreModel = SemaphoreModel.create(semaphoreList);
        ConditionModel conditionModel = ConditionModel.create(conditionList);
        //Controllers
        ProcessController controller = ProcessController.create(model);
        AboutWindowController aboutWindowController = AboutWindowController.create(primaryStage, aboutWindow);

        ExitController exitController = ExitController.create(exit);
        exitController.setStage(primaryStage);

        ChooseFileController chooseFileController = ChooseFileController.create(primaryStage, chooseFile);

        ////Gui

        //Console
        ConsoleView console = (ConsoleView) ConsoleAbstract.create();
        //ConsoleOutput consoleOutput = (ConsoleOutput) ConsoleAbstract.create();

        //Menu Bar
        MenuBarView menubar = MenuBarView.create(controller, aboutWindowController, exitController, chooseFileController, executableFile);

        //Side button bar
        SideBarView sideLeftBar = SideBarView.create(controller, chooseFileController, executableFile);

        //Gantt
        gantChartInitialize = GantChartInitialize.create();
        gantChartInitialize.setBthreadList(bthreadList.get());

        //About Window
        aboutWindowView = new AboutWindowView();

        //table
        tableView = StatusTable.create(statusList);
        mutexTable = MutexTable.create(mutexList);
        semaphoreTable = SemaphoreTable.create(semaphoreList);
        lockTable = LockTable.create(lockList);
        barrierTable = BarrierTable.create(barrierList);
        conditionTable = ConditionTable.create(conditionList);


        //Mediators
        CreateMediator createMediator = CreateMediator.create(statusModel, lockModel, mutexModel, semaphoreModel,
                barrierModel, conditionModel);

        MenuBarMediator menuBarMediator = MenuBarMediator.create();

        menuBarMediator.setStartProcessMenuItem(menubar.getStartProcessItemMenu());
        menuBarMediator.setPauseProcessMenuItem(menubar.getPauseItemMenu());
        menuBarMediator.setStopProcessMenuItem(menubar.getStopProcessItemMenu());
        menuBarMediator.setRestartProcessItem(menubar.getRestartItemMenu());
        menuBarMediator.setStartMonitoringMenuItem(menubar.getStartMonitoringItemMenu());
        menuBarMediator.setChooseFileMenuItem(menubar.getChooseFileItemMenu());
        menuBarMediator.setAboutWindow(menubar.getWindowItemMenu());

        menuBarMediator.setChooseFileSideButton(sideLeftBar.getOpenBtn());
        menuBarMediator.setStartProcessSideButton(sideLeftBar.getStartBtn());
        menuBarMediator.setPauseProcessSideButton(sideLeftBar.getPauseBtn());
        menuBarMediator.setStopProcessSideButton(sideLeftBar.getStopBtn());
        menuBarMediator.setRestartProcessSideButton(sideLeftBar.getRestartBtn());
        menuBarMediator.setStartMonitoringSideButton(sideLeftBar.getMonitoringBtn());

        menubar.getStartProcessItemMenu().getMenuItem().setDisable(true);
        menubar.getPauseItemMenu().getMenuItem().setDisable(true);
        menubar.getStopProcessItemMenu().getMenuItem().setDisable(true);
        menubar.getRestartItemMenu().getMenuItem().setDisable(true);
        menubar.getStartMonitoringItemMenu().getMenuItem().setDisable(true);

        sideLeftBar.getOpenBtn().getSideButton().setDisable(false);
        sideLeftBar.getStartBtn().getSideButton().setDisable(true);
        sideLeftBar.getPauseBtn().getSideButton().setDisable(true);
        sideLeftBar.getStopBtn().getSideButton().setDisable(true);
        sideLeftBar.getRestartBtn().getSideButton().setDisable(true);
        sideLeftBar.getMonitoringBtn().getSideButton().setDisable(true);

        //Scene
        Scene scene = new Scene(root, 1000, 1000);
        scene.getStylesheets().add("mainWindow.css");
        console.getConsole().appendText(Style.getHour() + "[INFO]  Bthread console started\n");

        //add children to the parents
        root.setTop(menubar.getMenu());
        root.setLeft(sideLeftBar.getSideLeftBar());
        root.setCenter(mainContentPane);

        mainContentPane.setCenter(tabContentPane);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(console.getConsole());
        mainContentPane.setBottom(hBox);

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
        lockTab.setContent(lockTable.getTableView());
        barrierTab.setContent(barrierTable.getTableView());
        mutexTab.setContent(mutexTable.getTableView());
        semaphoreTab.setContent(semaphoreTable.getTableView());
        conditionTab.setContent(conditionTable.getTableView());

        tabContentPane.getTabs().addAll(ganttTab, stateTab, barrierTab, lockTab, mutexTab, semaphoreTab, conditionTab);
        tabContentPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabContentPane.setTabMinWidth(70);

        primaryStage.setScene(scene);
        primaryStage.show();

        //observer
        //add observer
        parser.addObserver(createMediator);
        model.addObserver(console);
        model.addObserver(menuBarMediator);
        aboutWindow.addObserver(aboutWindowView);
        aboutWindow.addObserver(console);
        exit.addObserver(console);
        chooseFile.addObserver(console);
        chooseFile.addObserver(menuBarMediator);

        //add observer to observerList
        observerList.add(console);
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
