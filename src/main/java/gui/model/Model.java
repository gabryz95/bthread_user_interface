package gui.model;

import gui.event.*;
import gui.interfaces.ProcessManager;
import gui.model.date.*;
import gui.singleton.MainProcess;
import gui.view.MainWindowView;
import gui.view.ganttchart.GantChartInitialize;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Observable;

public class Model extends Observable implements ProcessManager {

    protected OutputProcessingThread opt;
    protected static Model model;
    protected Thread tableThread;
    //protected Thread ganttThread;
    protected Parser parser;
    protected ObservableList<Status> statusList;
    private ObservableList<Lock> lockList;
    protected ObservableList<Mutex> mutexList;
    protected ObservableList<Semaphore> semaphoreList;
    protected ObservableList<Barrier> barrierList;
    protected ObservableList<Condition> conditionList;
    protected volatile boolean isPuased = false;


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

    @Override
    public void startProcess(Process initProcess, String filename) throws IOException {
        if (MainProcess.getMainProcess().getCurrentProcess() == null) {
            MainProcess.getMainProcess().setCurrentProcess(initProcess);
            clearList();
            opt = OutputProcessingThread.create(initProcess, MainWindowView.getObserverList(), parser);
            tableThread = new Thread(opt);
            tableThread.setDaemon(false);
            tableThread.start();
//            ganttThread = new Thread(MainWindowView.getInstance().gantChartInitialize);
//            ganttThread.setDaemon(true);
//            ganttThread.start();
            this.setChanged();
            notifyObservers(new StartEvent(filename));
        } else {
            throw new IOException("start process is not null");
        }
    }


    @Override
    public void stopProcess(Process startedProcess, String filename) {
        startedProcess.destroyForcibly();
        MainProcess.getMainProcess().setCurrentProcess(null);
        try {
            tableThread.join();
            this.setChanged();
            notifyObservers(new StopEvent(filename));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
    public void pauseProcess(Process startedProcess, String filename) {
        try {
            int pid_process = executeProcessPid() + 1;
            if (!isPuased) {
                Runtime.getRuntime().exec("kill -SIGSTOP " + pid_process);
                isPuased = !isPuased;
                this.setChanged();
                notifyObservers(new PauseEvent(filename));
            } else {
                Runtime.getRuntime().exec("kill -SIGCONT " + pid_process);
                isPuased = !isPuased;
                this.setChanged();
                notifyObservers(new NotPauseEvent(filename));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void restartProcess(Process startedProcess, Process newProcess, String filename) {
        startedProcess.destroyForcibly();
        MainProcess.getMainProcess().setCurrentProcess(null);
        try {
            tableThread.join();
            startProcess(newProcess, filename);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void clearList() {
        statusList.clear();
        lockList.clear();
        mutexList.clear();
        semaphoreList.clear();
        barrierList.clear();
        conditionList.clear();
    }

    private int executeProcessPid() throws IOException {
        int pid_process = 0;
        Process process = Runtime.getRuntime().exec("jps -l");

        String line;
        BufferedReader in = new BufferedReader(new InputStreamReader(
                process.getInputStream(), "UTF-8"));

        for (int i = 0; i < 20; i++) {
            line = in.readLine();
            String[] javaProcess = line.split(" ");
            if (javaProcess.length > 2 && javaProcess[1].equalsIgnoreCase("Main")) {
                pid_process = Integer.valueOf(javaProcess[0]);
            }
        }
        process.destroyForcibly();
        return pid_process;
    }

}
