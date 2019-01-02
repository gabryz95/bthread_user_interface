package gui.command;

import gui.event.StopEvent;
import gui.singleton.MainProcess;

public class StopProcessCommand extends CommandAbs {

    public StopProcessCommand() {
    }

    @Override
    public void execute() {
        if (filename != null)
            receiver.stopProcess(stopProcess(filename));
    }

    protected Process stopProcess(String fileName){
        Process process = MainProcess.getMainProcess().getCurrentProcess();
        if(process != null){
            this.setChanged();
            this.notifyObservers(new StopEvent(fileName));
            return process;
        }else{
            return null;
        }
    }
}
