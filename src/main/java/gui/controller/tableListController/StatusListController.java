package gui.controller.tableListController;

import gui.model.date.Status;
import gui.model.date.datemodel.StatusModel;
import gui.view.MainWindowView;
import gui.view.ganttchart.GantChartInitialize;
import javafx.collections.ObservableList;

public class StatusListController {

    protected StatusModel statusModel;

    public static StatusListController create(StatusModel statusModel) {

        if (statusModel == null)
            return null;

        StatusListController statusListController = new StatusListController();
        statusListController.statusModel = statusModel;
        return statusListController;
    }

    public void controll(Status status) {
        if (status != null) {
            String statusValue = status.getStatus();
            if (statusValue.equalsIgnoreCase("CREATE")) {
                addElementToStatusList(status);
            } else if (statusValue.equalsIgnoreCase("READY")) {
                updateValueList(status, "READY");
            } else if (statusValue.equalsIgnoreCase("SLEEPING")) {
                updateValueList(status, "SLEEPING");
            } else if (statusValue.contains("BLOCKED")) {
                updateValueList(status, "BLOCKED");
            } else if (statusValue.equalsIgnoreCase("EXIT")) {
                updateValueList(status, "EXIT");
            } else if (statusValue.equalsIgnoreCase("SCHEDULING")) {
                updateValueList(status, "RUNNING");
            }
        }
    }

    protected void updateValueList(Status status, String value) {
        GantChartInitialize.ready = true;
        for (int i = 0; i < statusModel.listSize(); i++) {
            Status element = statusModel.getElementByIndex(i);
            if (element.getThreadId() == status.getThreadId()) {
                statusModel.updateElementStatus(i, value);
                reloadData();
            }
        }
    }

    protected void addElementToStatusList(Status status) {
        statusModel.addElement(status);
    }

    protected void reloadData() {
        MainWindowView.tableView.getTableView().refresh();
    }
}
