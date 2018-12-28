package gui.controller;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;

import static org.junit.Assert.*;

public class ChooseFileControllerTest {

    private Stage stage;
    private FileChooser fileChooser;
    private ProcessController receiver;


    @Test(expected = IllegalStateException.class)
    public void execute01() {
        this.fileChooser = new FileChooser();
        this.stage = null;
        File file = fileChooser.showOpenDialog(stage);
        assertNull(file);
    }

    @Test
    public void execute02() {
        this.stage = Mockito.mock(Stage.class);
        this.fileChooser = new FileChooser();
        this.receiver = Mockito.mock(ProcessController.class);
    }



}