package gui.model;

import gui.event.AboutEvent;
import gui.event.ChooseFileEvent;
import gui.event.ExitEvent;
import gui.event.MonitoringStartedEvent;
import gui.interfaces.ProcessManager;
import gui.model.date.*;
import gui.singleton.MainProcess;
import gui.view.MainWindowView;
import gui.view.ganttchart.GantChartInitialize;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.Observable;

public class Model extends Observable implements ProcessManager {

    protected OutputProcessingThread opt;
    protected static Model model;
    protected Thread tableThread;
    protected Thread ganttThread;
    protected Parser parser;
    protected ObservableList<Status> statusList;
    private ObservableList<Lock> lockList;
    protected ObservableList<Mutex> mutexList;
    protected ObservableList<Semaphore> semaphoreList;
    protected ObservableList<Barrier> barrierList;
    protected ObservableList<Condition> conditionList;


    //singleton
    public static Model create(Parser parser, ObservableList<Status> statusList, ObservableList<Lock> lockList, ObservableList<Mutex> mutexList, ObservableList<Semaphore> semaphoreList,
                               ObservableList<Barrier> barrierList, ObservableList<Condition> conditionList) {

        if (parser == null)
            return null;
        if (statusList == null)
            return null;
        if (lockList == null)
            return null;
        if (mutexList == null)
            return null;
        if (semaphoreList == null)
            return null;
        if (barrierList == null)
            return null;
        if (conditionList == null)
            return null;

        if (model == null) {
            model = new Model();
            model.parser = parser;
            model.statusList = statusList;
            model.lockList = lockList;
            model.mutexList = mutexList;
            model.semaphoreList = semaphoreList;
            model.barrierList = barrierList;
            model.conditionList = conditionList;
        }
        return model;
    }

    //TODO: eliminare tutti gli elemnti delle liste delle tabelle quando rifaccio partire il processo
    @Override
    public void startProcess(Process initProcess) throws IOException {
        if (MainProcess.getMainProcess().getCurrentProcess() == null) {
            MainProcess.getMainProcess().setCurrentProcess(initProcess);
            clearList();
            this.setChanged();
            opt = OutputProcessingThread.create(initProcess, MainWindowView.getObserverList(), parser);
            tableThread = new Thread(opt);
            tableThread.setDaemon(false);
            tableThread.start();
            ganttThread = new Thread(MainWindowView.getInstance().gantChartInitialize);
            ganttThread.setDaemon(true);
            ganttThread.start();
        } else {
            throw new IOException("start process is not null");
        }
    }


    @Override
    public void stopProcess(Process startedProcess) {
        startedProcess.destroyForcibly();
        MainProcess.getMainProcess().setCurrentProcess(null);
        MainWindowView.getInstance().gantChartInitialize.setIsRunning(false);
        try {
            tableThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void exitProcess() {
        this.setChanged();
        this.notifyObservers(new ExitEvent());
    }

    //NON DEVE STARE NEL MODEL
    @Override
    public void chooseFileProcess() {
        this.setChanged();
        this.notifyObservers(new ChooseFileEvent());
    }

    @Override
    public void startMonitoring(Process startedProcess) {
        if (startedProcess != null) {
            opt.setIsMonitoring(true);
            setChanged();
            notifyObservers(new MonitoringStartedEvent());
        }
    }

    @Override
    public void pauseProcess(Process startedProcess) {
        if (startedProcess != null) {
            //TODO: controllare processo se è in pausa tramite POSIX
        }
    }

    @Override
    public void restartProcess(Process startedProcess, Process newProcess) {
        startedProcess.destroyForcibly();
        MainProcess.getMainProcess().setCurrentProcess(null);
        try {
            startProcess(newProcess);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void aboutWindow() {
        this.setChanged();
        this.notifyObservers(new AboutEvent());
    }

    public void clearList() {
        statusList.clear();
        lockList.clear();
        mutexList.clear();
        semaphoreList.clear();
        barrierList.clear();
        conditionList.clear();
    }
}
