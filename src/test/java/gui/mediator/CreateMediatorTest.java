package gui.mediator;


import gui.controller.tableListController.*;
import gui.event.myDateEvent.*;
import gui.model.date.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;


import java.util.ArrayList;
import java.util.Observable;

import static org.junit.Assert.*;


public class CreateMediatorTest {

    @Mock
    private StatusListController statusListController;
    @Mock
    private LockListController lockListController;
    @Mock
    private MutexListController mutexListController;
    @Mock
    private SemaphoreListController semaphoreListController;
    @Mock
    private BarrierListController barrierListController;
    @Mock
    private ConditionListController conditionListController;

    private ObservableList<Status> statusObservableList;
    private ObservableList<Lock> lockObservableList;
    private ObservableList<Mutex> mutexObservableList;
    private ObservableList<Semaphore> semaphoreObservableList;
    private ObservableList<Barrier> barrierObservableList;
    private ObservableList<Condition> conditionObservableList;
    private CreateMediator createMediator;

    @Before
    public void setUp() {
        statusListController = Mockito.mock(StatusListController.class);
        lockListController = Mockito.mock(LockListController.class);
        mutexListController = Mockito.mock(MutexListController.class);
        semaphoreListController = Mockito.mock(SemaphoreListController.class);
        barrierListController = Mockito.mock(BarrierListController.class);
        conditionListController = Mockito.mock(ConditionListController.class);

        statusObservableList = FXCollections.observableArrayList(new ArrayList<>());
        lockObservableList = FXCollections.observableArrayList(new ArrayList<>());
        mutexObservableList = FXCollections.observableArrayList(new ArrayList<>());
        semaphoreObservableList = FXCollections.observableArrayList(new ArrayList<>());
        barrierObservableList = FXCollections.observableArrayList(new ArrayList<>());
        conditionObservableList = FXCollections.observableArrayList(new ArrayList<>());

        createMediator = CreateMediator.create(statusObservableList, lockObservableList, mutexObservableList, semaphoreObservableList, barrierObservableList, conditionObservableList);
    }

    @Test
    public void create01() {
        assertNull(CreateMediator.create(null, lockObservableList, mutexObservableList, semaphoreObservableList, barrierObservableList, conditionObservableList));
        assertNull(CreateMediator.create(statusObservableList, null, mutexObservableList, semaphoreObservableList, barrierObservableList, conditionObservableList));
        assertNull(CreateMediator.create(statusObservableList, lockObservableList, null, semaphoreObservableList, barrierObservableList, conditionObservableList));
        assertNull(CreateMediator.create(statusObservableList, lockObservableList, mutexObservableList, null, barrierObservableList, conditionObservableList));
        assertNull(CreateMediator.create(statusObservableList, lockObservableList, mutexObservableList, semaphoreObservableList, null, conditionObservableList));
        assertNull(CreateMediator.create(statusObservableList, lockObservableList, mutexObservableList, semaphoreObservableList, barrierObservableList, null));

    }


    @Test
    public void create06() {
        assertNotNull(createMediator);
    }

    @Test
    public void setMutexListController() {
        createMediator.setMutexListController(mutexListController);
        assertEquals(mutexListController, createMediator.mutexListController);
    }

    @Test
    public void setSemaphoreListController() {
        createMediator.setSemaphoreListController(semaphoreListController);
        assertEquals(semaphoreListController, createMediator.semaphoreListController);
    }

    @Test
    public void setBarrierListController() {
        createMediator.setBarrierListController(barrierListController);
        assertEquals(barrierListController, createMediator.barrierListController);
    }

    @Test
    public void setConditionListController() {
        createMediator.setConditionListController(conditionListController);
        assertEquals(conditionListController, createMediator.conditionListController);
    }

    @Test
    public void setStatusListController() {
        createMediator.setStatusListController(statusListController);
        assertEquals(statusListController, createMediator.statusListController);
    }

    @Test
    public void setLockonditionListController() {
        createMediator.setLockListController(lockListController);
        assertEquals(lockListController, createMediator.lockListController);
    }


    //TODO: fix these two tests
    @Test
    public void update01() {
        Observable observable = Mockito.mock(Observable.class);
        MyDataEvent mutexEvent = MutexEvent.create("(MUTACQUIRE) 2 0x345878");
        createMediator.update(observable, mutexEvent);
        //Mockito.verify(mutexListController, Mockito.times(1)).controll((Mutex) mutexEvent.getData());
    }

    @Test
    public void update02() {
        Observable observable = Mockito.mock(Observable.class);
        MyDataEvent semaphoreEvent = SemaphoreEvent.create("(SEMPOST) 2 0x345878 1");
        createMediator.update(observable, semaphoreEvent);
        //Mockito.verify(semaphoreListController, Mockito.times(1)).controll((Semaphore) semaphoreEvent.getData());
    }

    @Test
    public void update03() {
        Observable observable = Mockito.mock(Observable.class);
        MyDataEvent barrierEvent = BarrierEvent.create("(BARRIERWAIT) 2 0x107b4c198 1 9");
        createMediator.update(observable, barrierEvent);
        //Mockito.verify(barrierListController, Mockito.times(1)).controll((Barrier) barrierEvent.getData());
    }

    @Test
    public void update04() {
        Observable observable = Mockito.mock(Observable.class);
        MyDataEvent conditionEvent = ConditionEvent.create("(CONDSIGNAL) 2 0x345878 1");
        //createMediator.update(observable, conditionEvent);
        //Mockito.verify(conditionListController, Mockito.times(1)).controll((Condition) conditionEvent.getData());
    }

    @Test
    public void update05() {
        Observable observable = Mockito.mock(Observable.class);
        MyDataEvent statusEvent = StatusEvent.create("(CREATE) 2 ");
        //createMediator.update(observable, conditionEvent);
        //Mockito.verify(statusListController, Mockito.times(1)).controll((Status) statusEvent.getData());
    }

    @Test
    public void update06() {
        Observable observable = Mockito.mock(Observable.class);
        MyDataEvent lockEvent = LockEvent.create("(SCHEDULING) 5");
        //createMediator.update(observable, conditionEvent);
        //Mockito.verify(lockListController, Mockito.times(1)).controll((Lock) lockEvent.getData());
    }
}
