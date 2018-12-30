package gui.controller;

import gui.model.Mutex;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MutexListControllerTest {

    private ObservableList<Mutex> mutexObservableList;
    private MutexListController mutexListController;

    @Before
    public void setUp() {
        mutexObservableList = FXCollections.observableArrayList(new ArrayList<>());
    }

    @Test
    public void create01() {
        mutexListController = MutexListController.create(null);
        assertNull(mutexListController);
    }

    @Test
    public void create02() {
        mutexListController = MutexListController.create(mutexObservableList);
        assertNotNull(mutexListController);
    }

    @Test
    public void controll() {
        Mutex mutex = Mockito.mock(Mutex.class);
        mutexListController = Mockito.mock(MutexListController.class);
        mutexListController.controll(mutex);
        Mockito.verify(mutexListController, Mockito.times(1)).controll(mutex);
    }

    @Test
    public void mutacquireFunction() {
        Mutex mutex = Mockito.mock(Mutex.class);
        mutexListController = Mockito.mock(MutexListController.class);
        mutexListController.mutacuireFunction(mutex);
        Mockito.verify(mutexListController, Mockito.times(1)).mutacuireFunction(mutex);
    }

    @Test
    public void mutreleaseFunction() {
        Mutex mutex = Mockito.mock(Mutex.class);
        mutexListController = Mockito.mock(MutexListController.class);
        mutexListController.mutreleaseFunction(mutex);
        Mockito.verify(mutexListController, Mockito.times(1)).mutreleaseFunction(mutex);
    }
}