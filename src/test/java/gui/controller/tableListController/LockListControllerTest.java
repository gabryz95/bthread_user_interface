package gui.controller.tableListController;

import gui.model.date.Lock;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LockListControllerTest {

    private LockListController lockListController;
    private ObservableList<Lock> lockObservableList;

    @BeforeEach
    void setUp() {
        lockObservableList = FXCollections.observableArrayList(new ArrayList<>());
        lockListController = LockListController.create(lockObservableList);
    }

    @Test
    public void create01() {
        assertNull(LockListController.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(lockListController);
    }

    @Test
    public void controll01() {
        Lock lock = Lock.create("(SCHEDULING) 5");
        lockListController.controll(lock);
        assertEquals(5, lockListController.lockList.get(0).getThreadId());
        assertEquals(null, lockListController.lockList.get(0).getStatus());
    }

    @Test
    public void controll02() {
        Lock lock = Lock.create("(SCHEDULING) 5");
        lockListController.controll(lock);
        assertEquals(null, lockListController.lockList.get(0).getStatus());
        Lock lock1 = Lock.create("(SCHEDULING) 5");
//        lockListController.controll(lock1);
//        assertEquals("LOCK", lockListController.lockList.get(0).getStatus());
    }

    @Test
    public void removeLockStatuFromElement() {
        Lock lock = Lock.create("(SCHEDULING) 5");
        lock.setStatus("LOCK");
        lockListController.addElementToLockList(lock);
        assertEquals(5, lockListController.lockList.get(0).getThreadId());
        assertEquals("LOCK", lockListController.lockList.get(0).getStatus());
//        removeLockStatuFromElement();
//        assertEquals(null, lockListController.lockList.get(0).getStatus());
    }

    @Test
    public void addElementToLockList() {
        Lock lock = Lock.create("(SCHEDULING) 5");
        lockListController.addElementToLockList(lock);
        assertEquals(1, lockListController.lockList.size());
    }
}