package gui.view.table;

import gui.model.Bthread;
import gui.style.Style;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Observable;
import java.util.Observer;

public class StatusTable implements Observer {
    protected TableView tableView;

    public StatusTable() {
    }

    public static StatusTable create() {

        StatusTable statusTable = new StatusTable();
        TableColumn pidColumn = new TableColumn("ID Thread");
        pidColumn.setCellValueFactory(new PropertyValueFactory<>("pid"));
        TableColumn timeColumn = new TableColumn("Status");
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        statusTable.tableView = new TableView();
        statusTable.tableView.getColumns().addAll(pidColumn, timeColumn);
        statusTable.tableView.setEditable(false);

        pidColumn.prefWidthProperty().bind(statusTable.tableView.widthProperty().multiply(0.5));
        timeColumn.prefWidthProperty().bind(statusTable.tableView.widthProperty().multiply(0.5));

        statusTable.tableView.getStyleClass().add("tableView");
        statusTable.tableView.getStylesheets().add(Style.getCSS());
        statusTable.tableView.getItems().add(new Bthread(1));
        return statusTable;
    }

    public TableView getTableView() {
        return tableView;
    }

    public void clearTable() {
        tableView.getItems().clear();
    }


    public String retrieveStatus(Bthread b) {
        String status = b.getStatus();
        switch (status) {
            case "CREATE":
                addRow(b);
            case "READY":
                return "(READY)";
            case "SLEEPING":
                return "(SLEEPING)";
            case "MUTBLOCKED":
            case "SEMBLOCKED":
            case "CONDBLOCKED":
                return "(BLOCKED)";
            case "EXIT":
                return "(ZOMBIE)";
            case "SCHEDULING":
                return "(RUNNING)";
        }
        //if(status.equalsIgnoreCase(item.getStatus()))
        return null;
    }

    public void addRow(Bthread b) {
        tableView.getItems().add(b.getPid() - 1, b);
    }

    @Override
    public void update(Observable o, Object event) {
//        if (event instanceof BthreadChangeStatus) {
//            Bthread b = ((BthreadChangeStatus) event).getBthread();
//            String state = retrieveStatus(b);
//            try {
//                if(state!=null){
//                    Bthread item = (Bthread) tableView.getItems().get(b.getPid() - 1);
//                    item.setStatus(state);
//                    tableView.refresh();
//                }
//
//            } catch (IndexOutOfBoundsException e) {
//                //  tableView.getItems().add(b.getPid()-1,b);
//                //   tableView.getItems().addAll(b);
//            }
//        } else if (event instanceof StartEvent) {
//            //clearTable();
//        } else if (event instanceof RestartEvent) {
//            clearTable(); //TODO: migliorare funzione
//        }
    }
}
