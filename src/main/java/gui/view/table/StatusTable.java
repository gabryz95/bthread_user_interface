package gui.view.table;

import gui.style.Style;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class StatusTable {

    protected TableView tableView;

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
        return statusTable;
    }

    public TableView getTableView() {
        return tableView;
    }
}
