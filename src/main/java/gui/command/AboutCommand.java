package gui.command;

public class AboutCommand extends CommandAbs {
    @Override
    public void execute() {
        receiver.aboutWindow();
    }
}
