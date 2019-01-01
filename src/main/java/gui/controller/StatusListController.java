package gui.controller;

import gui.model.date.Status;
import gui.view.MainWindowView;
import javafx.collections.ObservableList;

public class StatusListController {

    protected ObservableList<Status> statusList;

    public static StatusListController create(ObservableList<Status> statusList) {

        if (statusList == null)
            return null;

        StatusListController statusListController = new StatusListController();
        statusListController.statusList = statusList;
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
                updateValueList(status, "SCHEDULING");
            }
        }
    }

    protected void updateValueList(Status status, String value) {
        for (Status element : statusList) {
            if (element.getThreadId() == status.getThreadId()) {
                element.setStatus(value);
                reloadData();
            }
        }
    }

    protected void addElementToStatusList(Status status) {
        statusList.add(status);
    }

    private void reloadData() {
        MainWindowView.tableView.getTableView().refresh(); //TODO: da sistemare
    }
}
