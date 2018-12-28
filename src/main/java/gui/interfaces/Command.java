package gui.interfaces;

import gui.controller.ProcessController;

import java.io.IOException;


public interface Command {

    Command create(final ProcessController receiver, String filename);

    void execute() throws IOException;
}
