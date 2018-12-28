package gui.controller;

import gui.interfaces.ProcessManager;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ProcessControllerTest {

    @Mock
    ProcessManager processManager;
    private ProcessController processController;

    @Before
    public void setUp() {
        processManager = mock(ProcessManager.class);
        processController = ProcessController.create(processManager);
    }

    @Test
    public void create01() {
        assertNull(ProcessController.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(ProcessController.create(processManager));
    }

    @Test
    public void startProcess() throws IOException {
        processController.startProcess(any(Process.class));
        Mockito.verify(processManager, Mockito.times(1)).startProcess(any(Process.class));
    }

    @Test
    public void stopProcess() {
        processController.stopProcess(any(Process.class));
        Mockito.verify(processManager, Mockito.times(1)).stopProcess(any(Process.class));
    }

    @Test
    public void exitProcess() {
        processController.exitProcess();
        Mockito.verify(processManager, Mockito.times(1)).exitProcess();
    }

    @Test
    public void chooseFileProcess() {
        processController.chooseFileProcess();
        Mockito.verify(processManager, Mockito.times(1)).chooseFileProcess();
    }

    @Test
    public void startMonitoring() {
        processController.startMonitoring(any(Process.class));
        Mockito.verify(processManager, Mockito.times(1)).startMonitoring(any(Process.class));
    }

    @Test
    public void restartProcess() {
        processController.restartProcess(any(Process.class), any(Process.class));
        Mockito.verify(processManager, Mockito.times(1)).restartProcess(any(Process.class), any(Process.class));
    }

    @Test
    public void pauseProcess() {
        processController.pauseProcess(any(Process.class));
        Mockito.verify(processManager, Mockito.times(1)).pauseProcess(any(Process.class));
    }

    @Test
    public void aboutWindow() {
        processController.aboutWindow();
        Mockito.verify(processManager, Mockito.times(1)).aboutWindow();
    }
}