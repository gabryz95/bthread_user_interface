package gui.model;

import gui.model.date.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;

public class ModelTest {

    @Mock
    private Model model;
    @Mock
    private Parser parser;

    private ObservableList<Status> statusObservableList;
    private ObservableList<Lock> lockObservableList;
    private ObservableList<Mutex> mutexObservableList;
    private ObservableList<Semaphore> semaphoreObservableList;
    private ObservableList<Barrier> barrierObservableList;
    private ObservableList<Condition> conditionObservableList;

    @Before
    public void setUp() {
        model = Mockito.mock(Model.class);
        parser = Mockito.mock(Parser.class);
        statusObservableList = FXCollections.observableArrayList(new ArrayList<>());
        lockObservableList = FXCollections.observableArrayList(new ArrayList<>());
        mutexObservableList = FXCollections.observableArrayList(new ArrayList<>());
        semaphoreObservableList = FXCollections.observableArrayList(new ArrayList<>());
        barrierObservableList = FXCollections.observableArrayList(new ArrayList<>());
        conditionObservableList = FXCollections.observableArrayList(new ArrayList<>());
    }

    @Test
    public void create01() {
        assertNull(Model.create(null, statusObservableList, lockObservableList, mutexObservableList, semaphoreObservableList, barrierObservableList, conditionObservableList));
    }

    @Test
    public void create02() {
        assertNull(Model.create(parser, null, lockObservableList, mutexObservableList, semaphoreObservableList, barrierObservableList, conditionObservableList));
    }

    @Test
    public void create03() {
        assertNull(Model.create(parser, statusObservableList, null, mutexObservableList, semaphoreObservableList, barrierObservableList, conditionObservableList));
    }

    @Test
    public void create04() {
        assertNull(Model.create(parser, statusObservableList, lockObservableList, null, semaphoreObservableList, barrierObservableList, conditionObservableList));
    }

    @Test
    public void create05() {
        assertNull(Model.create(parser, statusObservableList, lockObservableList, mutexObservableList, null, barrierObservableList, conditionObservableList));
    }

    @Test
    public void create06() {
        assertNull(Model.create(parser, statusObservableList, lockObservableList, mutexObservableList, semaphoreObservableList, null, conditionObservableList));
    }

    @Test
    public void create07() {
        assertNull(Model.create(parser, statusObservableList, lockObservableList, mutexObservableList, semaphoreObservableList, barrierObservableList, null));
    }

    @Test
    public void create08() {
        assertNotNull(Model.create(parser, statusObservableList, lockObservableList, mutexObservableList, semaphoreObservableList, barrierObservableList, conditionObservableList));
    }

    @Test
    public void startProcessTest() throws IOException {
        model.startProcess(any(Process.class));
        Mockito.verify(model, Mockito.times(1)).startProcess(any(Process.class));
    }

    @Test
    public void stopProcess() {
        model.stopProcess(any(Process.class));
        Mockito.verify(model, Mockito.times(1)).stopProcess(any(Process.class));
    }

    @Test
    public void exitProcess() {
    }

    @Test
    public void chooseFileProcess() {
    }

    @Test
    public void startMonitoring() {
    }

    @Test
    public void restartProcess() {
    }

    @Test
    public void pauseProcess() {
    }
}