package gui.command;

import gui.event.PauseEvent;
import gui.interfaces.CommandAbs;
import gui.singleton.MainProcess;

public class PauseProcessCommand extends CommandAbs {

    public PauseProcessCommand() {
    }

    @Override
    public void execute() {
        if (filename != null){
            this.setChanged();
            this.notifyObservers(new PauseEvent(filename));
            receiver.pauseProcess(getProcess());
        }
    }

    private Process getProcess(){
        return MainProcess.getMainProcess().getCurrentProcess();
    }

}
