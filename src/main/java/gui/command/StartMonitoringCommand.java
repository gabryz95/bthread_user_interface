package gui.command;

import gui.singleton.MainProcess;

public class StartMonitoringCommand extends CommandAbs{

    @Override
    public void execute(){
        receiver.startMonitoring(getProcess());
    }

    protected Process getProcess(){
        return MainProcess.getMainProcess().getCurrentProcess();
    }
}
