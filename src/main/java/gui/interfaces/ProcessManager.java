package gui.interfaces;

import java.io.IOException;

public interface ProcessManager {
    void startProcess(Process initProcess) throws IOException;
    void stopProcess(Process startedProcess);
    void exitProcess();
    void chooseFileProcess();
    void startMonitoring(Process startedProcess);
    void pauseProcess(Process startedProcess);
    void restartProcess(Process startedProcess, Process newProcess);
    void aboutWindow();
}
