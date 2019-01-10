package gui.view.console;

import gui.event.*;
import gui.style.Style;
import javafx.application.Platform;
import javafx.scene.control.TextArea;

import java.util.Observable;
import java.util.Observer;

public class ConsoleView extends ConsoleAbstract implements Observer {

    @Override
    public void update(Observable o, Object event) {
        if (event instanceof StartEvent) {
            clearConsole();
            console.appendText(((StartEvent) event).getString() + "\n");
        } else if (event instanceof PauseEvent) {
            console.appendText(((PauseEvent) event).getString() + "\n");
        } else if (event instanceof StopEvent) {
            console.appendText(((StopEvent) event).getString() + "\n");
        } else if (event instanceof ExitEvent) {
            console.appendText(((ExitEvent) event).getString() + "\n");
        } else if (event instanceof ChooseFileEvent) {
            console.appendText(((ChooseFileEvent) event).getString() + "\n");
        } else if (event instanceof RestartEvent) {
            clearConsole();
            console.appendText(((RestartEvent) event).getString() + "\n");
        } else if (event instanceof NewLineReadEvent) {
            Platform.runLater(() -> console.appendText(((NewLineReadEvent) event).getLine()));
        } else if (event instanceof AboutEvent) {
            console.appendText(((AboutEvent) event).getString() + "\n");
        }
    }
}
