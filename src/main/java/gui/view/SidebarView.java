package gui.view;

import gui.command.RestartProcessCommand;
import gui.command.StartMonitoringCommand;
import gui.command.StartProcessCommand;
import gui.command.StopProcessCommand;
import gui.controller.ChooseFileController;
import gui.controller.ProcessController;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SidebarView {
    protected Button openBtn;
    protected SideButtonView startBtn;
    protected SideButtonView stopBtn;
    protected SideButtonView restartBtn;
    protected SideButtonView monitoringBtn;
    protected VBox sideLeftBar;


    public SidebarView(final Stage stage, final ProcessController controller){
        sideLeftBar = new VBox();
        sideLeftBar.getStyleClass().add("sidebar");
        openBtn = new Button();
        openBtn.getStyleClass().add("openBtn");

        this.startBtn = new SideButtonView("startBtn", new StartProcessCommand(), controller, MainWindowView.getObserverList());
        this.stopBtn = new SideButtonView("stopBtn", new StopProcessCommand(), controller, MainWindowView.getObserverList());
        this.restartBtn = new SideButtonView("restartBtn", new RestartProcessCommand(), controller, MainWindowView.getObserverList());
        this.monitoringBtn = new SideButtonView("monitoringBtn", new StartMonitoringCommand(), controller, MainWindowView.getObserverList());

        //aggiungo gli elementi
        sideLeftBar.getChildren().addAll(openBtn, startBtn.getSideButton(), stopBtn.getSideButton(), restartBtn.getSideButton(), monitoringBtn.getSideButton());

        //actions
        final ChooseFileController chooseFileController = new ChooseFileController(stage, controller);
        openBtn.setOnAction(e -> chooseFileController.execute());
    }

    public VBox getSideLeftBar() { return sideLeftBar; }
    public SideButtonView getStartBtn(){return startBtn; }
    public SideButtonView getStopBtn(){return  stopBtn; }
    public SideButtonView getRestartBtn() {return restartBtn;}
    public SideButtonView getMonitoringBtn() {return monitoringBtn; }
}
