package gui.command;

import gui.singleton.MainProcess;

public class StopProcessCommand extends CommandAbs {

    @Override
    public void execute() {
        if (filename != null)
            receiver.stopProcess(stopProcess(), filename);
    }

    protected Process stopProcess() {
        Process process = MainProcess.getMainProcess().getCurrentProcess();
        if (process != null) {
            return process;
        } else {
            return null;
        }
    }
}
