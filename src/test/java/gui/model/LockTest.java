package gui.model;

import gui.view.JavaFXInitTest;
import javafx.beans.property.SimpleStringProperty;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LockTest {
    private Lock lock;

    @Before
    public void init() throws InterruptedException {
        JavaFXInitTest jinit = new JavaFXInitTest();
        jinit.init();
        lock = new Lock("1", "STATUS");
    }

    @Test
    public void getThreadTest() {
        assertEquals(true , lock.getThread().equals("1"));
        assertEquals(false , lock.getThread().equals("2"));
    }
    @Test
    public void threadPropertyTest() {
        assertEquals(SimpleStringProperty.class, lock.threadProperty().getClass());
    }
    @Test
    public void setThreadTest() {
        lock.setThread("2");
        assertEquals(false, lock.getThread().equals("1"));
        assertEquals(true, lock.getThread().equals("2"));
    }
    @Test
    public void getLockStatusTest() {
        assertEquals(true, lock.getLockStatus().equals("STATUS"));
        assertEquals(false, lock.getLockStatus().equals("OTHER STATUS"));
    }
    @Test
    public void lockStatusPropertyTest() {
        assertEquals(SimpleStringProperty.class, lock.lockStatusProperty().getClass());
    }
    @Test
    public void setLockStatusTest() {
        lock.setLockStatus("LOCK");
        assertEquals(false, lock.getLockStatus().equals("STATUS"));
        assertEquals(true, lock.getLockStatus().equals("LOCK"));
    }
}
