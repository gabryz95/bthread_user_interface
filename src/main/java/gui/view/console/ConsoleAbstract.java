package gui.view.console;

import gui.style.Style;
import javafx.scene.control.TextArea;

public abstract class ConsoleAbstract {

    protected TextArea console;

    public static ConsoleAbstract create() {
        ConsoleView consoleView = new ConsoleView();
        consoleView.console = new TextArea();
        consoleView.console.setEditable(false);
        consoleView.console.setPrefRowCount(10);
        consoleView.console.getStyleClass().add("console");
        consoleView.console.getStylesheets().add(Style.getCSS());
        return consoleView;
    }

    public TextArea getConsole() {
        return console;
    }

    public void clearConsole() {
        console.clear();
    }
}
