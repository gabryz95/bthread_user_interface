package gui.mediator;


import gui.controller.BarrierListController;
import gui.controller.ConditionListController;
import gui.controller.MutexListController;
import gui.controller.SemaphoreListController;
import gui.event.*;
import gui.model.date.Barrier;
import gui.model.date.Condition;
import gui.model.date.Mutex;
import gui.model.date.Semaphore;
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
    private MutexListController mutexListController;
    @Mock
    private SemaphoreListController semaphoreListController;
    @Mock
    private BarrierListController barrierListController;
    @Mock
    private ConditionListController conditionListController;

    private ObservableList<Mutex> mutexObservableList;
    private ObservableList<Semaphore> semaphoreObservableList;
    private ObservableList<Barrier> barrierObservableList;
    private ObservableList<Condition> conditionObservableList;
    private CreateMediator createMediator;

    @Before
    public void setUp() {
        mutexListController = Mockito.mock(MutexListController.class);
        semaphoreListController = Mockito.mock(SemaphoreListController.class);
        barrierListController = Mockito.mock(BarrierListController.class);
        conditionListController = Mockito.mock(ConditionListController.class);
        mutexObservableList = FXCollections.observableArrayList(new ArrayList<>());
        semaphoreObservableList = FXCollections.observableArrayList(new ArrayList<>());
        barrierObservableList = FXCollections.observableArrayList(new ArrayList<>());
        conditionObservableList = FXCollections.observableArrayList(new ArrayList<>());
        createMediator = CreateMediator.create(mutexObservableList, semaphoreObservableList, barrierObservableList, conditionObservableList);

    }

    @Test
    public void create01() {
        assertNull(CreateMediator.create(null, semaphoreObservableList, barrierObservableList, conditionObservableList));
    }

    @Test
    public void create02() {
        assertNull(CreateMediator.create(mutexObservableList, null, barrierObservableList, conditionObservableList));
    }

    @Test
    public void create03() {
        assertNull(CreateMediator.create(mutexObservableList, semaphoreObservableList, null, conditionObservableList));
    }

    @Test
    public void create04() {
        assertNull(CreateMediator.create(mutexObservableList, semaphoreObservableList, barrierObservableList, null));
    }

    @Test
    public void create05() {
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
        MyDataEvent conditionEvent = ConditionEvent.create("(SEMPOST) 2 0x345878 1");
        createMediator.update(observable, conditionEvent);
        //Mockito.verify(conditionListController, Mockito.times(1)).controll((Condition) conditionEvent.getData());
    }
}
