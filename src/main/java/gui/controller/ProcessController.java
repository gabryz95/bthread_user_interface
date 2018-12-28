package gui.controller;

import gui.interfaces.ProcessManager;

import java.io.IOException;

public class ProcessController implements ProcessManager {
    private ProcessManager model;

    public static ProcessController create(ProcessManager model) {
        if (model == null) {
            return null;
        }

        ProcessController controller = new ProcessController();
        controller.model = model;

        return controller;
    }

    @Override
    public void startProcess(Process processName) throws IOException {
        model.startProcess(processName);
    }

    @Override
    public void stopProcess(Process startedProcess) {
        model.stopProcess(startedProcess);
    }

    @Override
    public void exitProcess() {
        model.exitProcess();
    }

    @Override
    public void chooseFileProcess() {
        model.chooseFileProcess();
    }

    @Override
    public void startMonitoring(Process startedProcess) {
        model.startMonitoring(startedProcess);
    }

    public void pauseProcess(Process startedProcess) {
        model.pauseProcess( startedProcess);
    }

    @Override
    public void restartProcess(Process startedProcess, Process newProcess) {
        model.restartProcess(startedProcess, newProcess);
    }

    @Override
    public void aboutWindow() {
        model.aboutWindow();
    }
}
