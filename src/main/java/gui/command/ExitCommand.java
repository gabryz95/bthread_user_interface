package gui.command;


public class ExitCommand extends CommandAbs {

    @Override
    public void execute() {
        exitController.exitProcess();
        exitController.getStage().close();
    }
}
