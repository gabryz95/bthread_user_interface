package gui.command;

import gui.interfaces.CommandAbs;

import java.io.IOException;

public class AboutCommand extends CommandAbs {
    @Override
    public void execute() {
        receiver.aboutWindow();
    }
}
