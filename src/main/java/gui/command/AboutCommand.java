package gui.command;

public class AboutCommand extends CommandAbs {

    @Override
    public void execute() {
        aboutWindowController.aboutWindow();
    }

}
