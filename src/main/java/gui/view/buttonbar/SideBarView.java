package gui.view.buttonbar;

import gui.command.*;
import gui.controller.ChooseFileController;
import gui.controller.ProcessController;
import javafx.scene.layout.VBox;

public class SideBarView {

    protected SideButtonView openBtn;
    protected SideButtonView startBtn;
    protected SideButtonView stopBtn;
    protected SideButtonView pauseBtn;
    protected SideButtonView restartBtn;
    protected SideButtonView monitoringBtn;
    protected VBox sideLeftBar;


    public static SideBarView create(final ProcessController processController, final ChooseFileController chooseFileController) {

        if (processController == null)
            return null;
        if (chooseFileController == null)
            return null;

        SideBarView sideBarView = new SideBarView();

        sideBarView.sideLeftBar = new VBox();
        sideBarView.sideLeftBar.getStyleClass().add("sidebar");

        sideBarView.openBtn = SideButtonView.create("openBtn", new ChooseFileCommand(), chooseFileController);
        sideBarView.startBtn = SideButtonView.create("startBtn", new StartProcessCommand(), processController);
        sideBarView.stopBtn = SideButtonView.create("stopBtn", new StopProcessCommand(), processController);
        sideBarView.pauseBtn = SideButtonView.create("pauseBtn", new PauseProcessCommand(), processController);
        sideBarView.restartBtn = SideButtonView.create("restartBtn", new RestartProcessCommand(), processController);
        sideBarView.monitoringBtn = SideButtonView.create("monitoringBtn", new StartMonitoringCommand(), processController);

        sideBarView.sideLeftBar.getChildren().addAll(sideBarView.openBtn.getSideButton(), sideBarView.startBtn.getSideButton(), sideBarView.stopBtn.getSideButton(),
                sideBarView.pauseBtn.getSideButton(), sideBarView.restartBtn.getSideButton(), sideBarView.monitoringBtn.getSideButton());

        return sideBarView;
    }

    public VBox getSideLeftBar() {
        return sideLeftBar;
    }

    public SideButtonView getOpenBtn() {
        return openBtn;
    }

    public SideButtonView getStartBtn() {
        return startBtn;
    }

    public SideButtonView getStopBtn() {
        return stopBtn;
    }

    public SideButtonView getPauseBtn() {
        return pauseBtn;
    }

    public SideButtonView getRestartBtn() {
        return restartBtn;
    }

    public SideButtonView getMonitoringBtn() {
        return monitoringBtn;
    }
}
