package gui.command;

import gui.event.RestartEvent;
import gui.interfaces.CommandAbs;
import gui.singleton.MainProcess;

import java.io.IOException;

public class RestartProcessCommand extends CommandAbs{

    @Override
    public void execute() {
        if (getProcess() != null) {
            receiver.restartProcess(getProcess(), initProcess(filename));
        }
    }

    protected Process initProcess(String fileName){
        Runtime rt = Runtime.getRuntime();
        try {
            Process process = rt.exec(fileName);
            this.setChanged();
            this.notifyObservers(new RestartEvent(fileName));
            return process;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected Process getProcess(){
        return MainProcess.getMainProcess().getCurrentProcess();
    }
}