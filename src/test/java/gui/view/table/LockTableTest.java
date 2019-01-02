package gui.view.table;

import gui.model.date.Lock;
import gui.view.JavaFXInitTest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static junit.framework.Assert.*;

public class LockTableTest {

    private LockTable lockTable;
    private ObservableList<Lock> lockObservableList;

    @BeforeEach
    public void init() throws InterruptedException {
        JavaFXInitTest jinit = new JavaFXInitTest();
        jinit.init();
        lockObservableList = FXCollections.observableArrayList(new ArrayList<>());
        lockTable = LockTable.create(lockObservableList);
    }

    @Test
    public void create01() {
        assertNull(LockTable.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(lockTable);
    }

    @Test
    public void getTableView() {
        assertEquals(lockTable.tableView, lockTable.getTableView());
    }
}
