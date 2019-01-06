package gui.command;

import gui.singleton.MainProcess;

public class PauseProcessCommand extends CommandAbs {

    @Override
    public void execute() {
        if (filename != null) {
                receiver.pauseProcess(getProcess(), filename);
        }
    }

    private Process getProcess() {
        return MainProcess.getMainProcess().getCurrentProcess();
    }

}
