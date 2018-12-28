package gui.view;

import gui.model.Semaphore;
import gui.view.table.SemaphoreTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SemaphoreTableTest {

    private SemaphoreTable semaphoreTable;
    private ObservableList<Semaphore> observableList;

    @Before
    public void init() throws InterruptedException {
        observableList = FXCollections.observableArrayList(new ArrayList<>());
        JavaFXInitTest jinit = new JavaFXInitTest();
        jinit.init();
    }

    @Test
    public void create01() {
        semaphoreTable = SemaphoreTable.create(null);
        assertNull(semaphoreTable);

    }

    @Test
    public void create02() {

        semaphoreTable = SemaphoreTable.create(observableList);
        assertNotNull(semaphoreTable);
    }

    @Test
    public void getTableView() {
        semaphoreTable = SemaphoreTable.create(observableList);
        assertEquals(semaphoreTable.getTableView(), semaphoreTable.getTableView());
    }
}