package gui.view;

import gui.model.Lock;
import gui.view.table.LockTableView;
import javafx.scene.control.TableView;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LockTableTest {

    protected static LockTableView lockTableView;


    @Before
    public void init() throws InterruptedException{
        JavaFXInitTest jinit = new JavaFXInitTest();
        jinit.init();
        lockTableView = new LockTableView();
    }

    @Test
    public void createTest(){
         assertEquals(lockTableView.getClass(), new LockTableView().getClass());
    }

    @Test
    public void addRowTest () {
        Lock lock1 = new Lock("1", "LOCK");
        assertEquals(true, lockTableView.addRow(lock1));
    }

    @Test
    public void getRowTest(){
        Lock lock1 = new Lock("1", "LOCK");
        Lock lock2 = new Lock("2", "LOCK");
        lockTableView.addRow(lock1);
        lockTableView.addRow(lock2);
        assertEquals(lock1, lockTableView.getRow(1));
        assertEquals(lock2, lockTableView.getRow(2));
        assertEquals(null, lockTableView.getRow(10));
    }

    @Test
    public void getRowsTest(){
        assertEquals(0, lockTableView.getRows().size());
        lockTableView.addRow(new Lock("1", "TEST"));
        lockTableView.addRow(new Lock("2", "TEST"));
        assertEquals(2, lockTableView.getRows().size());
    }

    @Test
    public void setTheadStatusLockTest() {
        assertEquals(false, lockTableView.setThreadStatusLock(1));
        lockTableView.addRow(new Lock("1", ""));
        lockTableView.addRow(new Lock("2", ""));
        assertEquals(true, lockTableView.setThreadStatusLock(1));
        assertEquals(true, lockTableView.getRow(1).getLockStatus().equals("LOCK"));
        assertEquals(true, lockTableView.getRow(2).getLockStatus().equals(""));

        assertEquals(true, lockTableView.setThreadStatusLock(2));
        assertEquals(false, lockTableView.getRow(1).getLockStatus().equals("LOCK"));
        assertEquals(true, lockTableView.getRow(2).getLockStatus().equals("LOCK"));
    }

    @Test
    public void getTableViewTest() {
        assertEquals(new TableView<Lock>().getClass(), lockTableView.getTableView().getClass());
    }

    @Test
    public void clearTableTest() {
        assertEquals(0, lockTableView.getTableView().getItems().size());
        assertEquals(true, lockTableView.addRow(new Lock("1", "LOCK")));
        assertEquals(true, lockTableView.addRow(new Lock("2", "LOCK")));
        assertEquals(2, lockTableView.getTableView().getItems().size());
        assertEquals(true, lockTableView.clearTable());
        assertEquals(0, lockTableView.getTableView().getItems().size());
    }
}
