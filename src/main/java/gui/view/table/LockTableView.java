package gui.view.table;

import gui.model.Lock;
import gui.style.Style;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class LockTableView {

    protected TableView<Lock> tableView;
    private final ObservableList<Lock> data = FXCollections.observableArrayList();

    public LockTableView() {
        this.tableView = new TableView<Lock>();
        init();
    }

    private void init() {
        tableView.setEditable(false);
        TableColumn threadColumn = new TableColumn("THREAD");
        TableColumn lockStatusTable = new TableColumn("LOCK STATUS");
        tableView.getColumns().addAll(threadColumn, lockStatusTable);

        threadColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.5));
        lockStatusTable.prefWidthProperty().bind(tableView.widthProperty().multiply(0.5));

        threadColumn.setCellValueFactory(new PropertyValueFactory<Lock, Integer>("thread"));
        lockStatusTable.setCellValueFactory(new PropertyValueFactory<Lock, String>("lockStatus"));

        tableView.getStyleClass().add("tableView");
        tableView.getStylesheets().add(Style.getCSS());
        tableView.getSortOrder().add(threadColumn);
        tableView.setItems(data);
    }

    public boolean addRow(Lock lock) {
        return tableView.getItems().add(lock);
    }

    public Lock getRow(int theadNumber) {
        ObservableList<Lock> locks = tableView.getItems();
        for (Lock l : locks) {
            if (l.getThread().equals(Integer.toString(theadNumber))) {
                return l;
            }
        }
        return null;
    }

    public ObservableList<Lock> getRows() {
        return tableView.getItems();
    }

    public boolean setThreadStatusLock(int threadNumber) {
        clearStatus();
        Lock lock = getRow(threadNumber);
        if(lock != null){
            lock.setLockStatus("LOCK");
            return true;
        }
        return false;
    }

    public TableView<Lock> getTableView() {
        return tableView;
    }

    public boolean clearTable() {
        tableView.getItems().clear();
        return true;
    }

    private void clearStatus() {
        ObservableList<Lock> locks = tableView.getItems();
        locks.forEach(l -> l.setLockStatus(""));
    }

}
