package gui.controller;

import gui.model.date.Semaphore;
import gui.view.JavaFXInitTest;
import gui.view.MainWindowView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SemaphoreListControllerTest {

    private ObservableList<Semaphore> semaphoreObservableList;
    private SemaphoreListController semaphoreListController;

    @Before
    public void setUp() throws InterruptedException {
        semaphoreObservableList = FXCollections.observableArrayList(new ArrayList());
        JavaFXInitTest jinit = new JavaFXInitTest();
        jinit.init();
    }

    @Test
    public void create01() {
        semaphoreListController = SemaphoreListController.create(null);
        assertNull(semaphoreListController);
    }

    @Test
    public void create02() {
        semaphoreListController = SemaphoreListController.create(semaphoreObservableList);
        assertNotNull(semaphoreListController);
    }

    @Test
    public void controll01() {
        Semaphore semaphore = Mockito.mock(Semaphore.class);
        semaphoreListController = Mockito.mock(SemaphoreListController.class);
        semaphoreListController.controll(semaphore);
        Mockito.verify(semaphoreListController, Mockito.times(1)).controll(semaphore);
    }

    @Test
    public void controll02() {

    }

    @Test
    public void sewaitFunction01() {
        Semaphore semaphore = Mockito.mock(Semaphore.class);
        semaphoreListController = Mockito.mock(SemaphoreListController.class);
        semaphoreListController.sewaitFunction(semaphore);
        Mockito.verify(semaphoreListController, Mockito.times(1)).sewaitFunction(semaphore);
    }

    @Test
    public void semwaitFunction02() {
        semaphoreListController = SemaphoreListController.create(semaphoreObservableList);
        semaphoreListController.sewaitFunction(Semaphore.create("(SEMWAIT) 2 0x1077dc0d0 0"));
        assertEquals(1, semaphoreListController.semaphoreList.size());
    }

    @Test
    public void semwaitFunction03() {
        MainWindowView mainWindowView = Mockito.mock(MainWindowView.class);
        semaphoreListController = SemaphoreListController.create(semaphoreObservableList);
        semaphoreListController.sempostFunction(Semaphore.create("(SEMPOST) 2 0x1077dc0d0 0"));
        //semaphoreListController.sewaitFunction(Semaphore.create("(SEMWAIT) 2 0x1077dc0d0 0"));
        //assertEquals(0, semaphoreListController.semaphoreList.get(0).getCounter());
    }

    @Test
    public void semacquireFunction01() {
        Semaphore semaphore = Mockito.mock(Semaphore.class);
        semaphoreListController = Mockito.mock(SemaphoreListController.class);
        semaphoreListController.semacquireFunction(semaphore);
        Mockito.verify(semaphoreListController, Mockito.times(1)).semacquireFunction(semaphore);
    }

    @Test
    public void sempostFunction01() {
        Semaphore semaphore = Mockito.mock(Semaphore.class);
        semaphoreListController = Mockito.mock(SemaphoreListController.class);
        semaphoreListController.sempostFunction(semaphore);
        Mockito.verify(semaphoreListController, Mockito.times(1)).sempostFunction(semaphore);
    }

    @Test
    public void sempostFunction02() {
        semaphoreListController = SemaphoreListController.create(semaphoreObservableList);
        semaphoreListController.sempostFunction(Semaphore.create("(SEMPOST) 2 0x1077dc0d0 0"));
        assertEquals(1, semaphoreListController.semaphoreList.get(0).getCounter());
    }
}