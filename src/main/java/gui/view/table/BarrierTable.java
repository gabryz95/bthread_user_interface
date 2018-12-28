package gui.view.table;

import gui.event.*;
import gui.model.Bthread;
import gui.style.Style;
import javafx.application.Platform;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class BarrierTable implements Observer {
    protected TableView tableView;
    protected Map<String, Integer> haveQueue = new HashMap<>();


    public static BarrierTable create() {
        BarrierTable barrierTable = new BarrierTable();
        TableColumn barrierColumn = new TableColumn("BARRIER ID");
        barrierColumn.setCellValueFactory(new PropertyValueFactory<>("barrier"));
        TableColumn counterColumn = new TableColumn("COUNTER");
        counterColumn.setCellValueFactory(new PropertyValueFactory<>("cnt"));
        TableColumn queueColumn = new TableColumn("QUEUE");
        queueColumn.setCellValueFactory(new PropertyValueFactory<>("queue"));
        barrierTable.tableView = new TableView();
        barrierTable.tableView.getColumns().addAll(barrierColumn, counterColumn, queueColumn);
        barrierTable.tableView.setEditable(false);

        barrierColumn.prefWidthProperty().bind(barrierTable.tableView.widthProperty().multiply(0.4));
        counterColumn.prefWidthProperty().bind(barrierTable.tableView.widthProperty().multiply(0.2));
        queueColumn.prefWidthProperty().bind(barrierTable.tableView.widthProperty().multiply(0.4));

        barrierTable.tableView.getStyleClass().add("tableView");
        barrierTable.tableView.getStylesheets().add(Style.getCSS());
        return barrierTable;
    }

    public void clearTable() {
        tableView.getItems().remove(0, tableView.getItems().size());
        tableView.refresh();
    }

    public void addRow(Bthread b) {
        tableView.getItems().add(b.getPid() - 1, b);
    }

    @Override
    public void update(Observable o, Object event) {
        if (event instanceof BarrierBlockedEvent) {
            Bthread b = ((BarrierBlockedEvent) event).getBthread();
            try {
                Bthread item = (Bthread) tableView.getItems().get(b.getPid() - 1);
                tableView.refresh();


            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        } else if (event instanceof BarrierUnlockEvent) {

        } else if (event instanceof BarrierWaitEvent) {

        } else if (event instanceof StartEvent) {
            clearTable();
        } else if (event instanceof RestartEvent) {
            Platform.runLater(this::clearTable);
        }
    }
}
