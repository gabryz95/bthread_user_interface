package gui.model;

import gui.model.date.Mutex;
import gui.model.date.Semaphore;
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

    private ObservableList<Mutex> mutexObservableList;
    private ObservableList<Semaphore> semaphoreObservableList;

    @Before
    public void setUp() {
        model = Mockito.mock(Model.class);
        parser = Mockito.mock(Parser.class);
        mutexObservableList = FXCollections.observableArrayList(new ArrayList<>());
        semaphoreObservableList = FXCollections.observableArrayList(new ArrayList<>());
    }

    @Test
    public void create01() {
        assertNull(Model.create(null, mutexObservableList, semaphoreObservableList));
    }

    @Test
    public void create02() {
        assertNull(Model.create(parser, null, semaphoreObservableList));
    }

    @Test
    public void create03() {
        assertNull(Model.create(parser, mutexObservableList, null));
    }

    @Test
    public void create04() {
        assertNotNull(Model.create(parser, mutexObservableList, semaphoreObservableList));
    }

//    @Test(expected = NullPointerException.class)
//    public void startProcess01() {
//        model.startProcess(null);
//    }
//
//    @Test(expected = NullPointerException.class)
//    public void startProcess02() {
//        model.startProcess(" ");
//    }
//
//    @Test
//    public void startProcess03() {
//        model.startProcess("/Users/gabrielezorloni/Google Drive/Supsi/Sistemi Operativi2/Laboratorio/Archive/philosophers");
//        verify(processManager).startProcess("/Users/gabrielezorloni/Google Drive/Supsi/Sistemi Operativi2/Laboratorio/Archive/philosophers");
//    }

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