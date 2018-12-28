package gui.mediator;


import gui.controller.MutexListController;
import gui.controller.SemaphoreListController;
import gui.event.MutexEvent;
import gui.event.SemaphoreEvent;
import gui.model.Mutex;
import gui.model.Semaphore;
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

    private ObservableList<Mutex> mutexObservableList;
    private ObservableList<Semaphore> semaphoreObservableList;
    private CreateMediator createMediator;

    @Before
    public void setUp() {
        mutexListController = Mockito.mock(MutexListController.class);
        semaphoreListController = Mockito.mock(SemaphoreListController.class);
        mutexObservableList = FXCollections.observableArrayList(new ArrayList<>());
        semaphoreObservableList = FXCollections.observableArrayList(new ArrayList<>());
        createMediator = CreateMediator.create(mutexObservableList, semaphoreObservableList);

    }

    @Test
    public void create01() {
        assertNull(CreateMediator.create(null, semaphoreObservableList));
    }

    @Test
    public void create02() {
        assertNull(CreateMediator.create(mutexObservableList, null));
    }

    @Test
    public void create03() {
        assertNotNull(createMediator);
    }

    @Test
    public void setMutexListController() {
        createMediator = CreateMediator.create(mutexObservableList, semaphoreObservableList);
        createMediator.setMutexListController(mutexListController);
        assertEquals(mutexListController, createMediator.mutexListController);
    }

    @Test
    public void setSemaphoreListController() {
        createMediator = CreateMediator.create(mutexObservableList, semaphoreObservableList);
        createMediator.setSemaphoreListController(semaphoreListController);
        assertEquals(semaphoreListController, createMediator.semaphoreListController);
    }

    //TODO: fix these two tests
    @Test
    public void update01() {
        Observable observable = Mockito.mock(Observable.class);
        MutexEvent mutexEvent = MutexEvent.create("(MUTACQUIRE) 2 0x345878");
        createMediator = CreateMediator.create(mutexObservableList, semaphoreObservableList);
        createMediator.update(observable, mutexEvent);
        //Mockito.verify(mutexListController, Mockito.times(1)).controll((Mutex) mutexEvent.getData());
    }

    @Test
    public void update02() {
        Observable observable = Mockito.mock(Observable.class);
        SemaphoreEvent semaphoreEvent = SemaphoreEvent.create("(SEMPOST) 2 0x345878 1");
        createMediator = CreateMediator.create(mutexObservableList, semaphoreObservableList);
        createMediator.update(observable, semaphoreEvent);
        //Mockito.verify(semaphoreListController, Mockito.times(1)).controll((Semaphore) semaphoreEvent.getData());
    }

}
