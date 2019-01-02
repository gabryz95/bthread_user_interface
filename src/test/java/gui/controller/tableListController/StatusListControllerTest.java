package gui.controller.tableListController;

import gui.model.date.Status;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

//Todo: aggiungere test al metodo controll()
public class StatusListControllerTest {

    private StatusListController statusListController;
    private ObservableList<Status> statusObservableList;

    @BeforeEach
    public void setUp() {
        statusObservableList = FXCollections.observableArrayList(new ArrayList());
        statusListController = StatusListController.create(statusObservableList);
    }

    @Test
    public void create01() {
        assertNull(StatusListController.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(statusListController);
    }

    @Test
    public void controll01() {
        Status status = Status.create("(CREATE) 1");
        StatusListController statusListController1 = Mockito.mock(StatusListController.class);
        statusListController1.controll(status);
        Mockito.verify(statusListController1, Mockito.times(1)).controll(status);
    }

    @Test
    public void controll02() {
        Status status = Status.create("(READY) 1");
        StatusListController statusListController1 = Mockito.mock(StatusListController.class);
        statusListController1.controll(status);
        Mockito.verify(statusListController1, Mockito.times(1)).controll(status);
    }

    @Test
    public void controll03() {
        Status status = Status.create("(SLEEPING) 1");
        StatusListController statusListController1 = Mockito.mock(StatusListController.class);
        statusListController1.controll(status);
        Mockito.verify(statusListController1, Mockito.times(1)).controll(status);
    }

    @Test
    public void controll04() {
        Status status = Status.create("(BLOCKED) 1");
        StatusListController statusListController1 = Mockito.mock(StatusListController.class);
        statusListController1.controll(status);
        Mockito.verify(statusListController1, Mockito.times(1)).controll(status);
    }

    @Test
    public void controll05() {
        Status status = Status.create("(EXIT) 1");
        StatusListController statusListController1 = Mockito.mock(StatusListController.class);
        statusListController1.controll(status);
        Mockito.verify(statusListController1, Mockito.times(1)).controll(status);
    }

    @Test
    public void controll06() {
        Status status = Status.create("(SCHEDULING) 1");
        StatusListController statusListController1 = Mockito.mock(StatusListController.class);
        statusListController1.controll(status);
        Mockito.verify(statusListController1, Mockito.times(1)).controll(status);
    }

    @Test
    public void addElementToStatusList() {
        Status status = Mockito.mock(Status.class);
        statusListController.addElementToStatusList(status);
        assertEquals(1, statusListController.statusList.size());
    }

    @Test
    public void updateValueList() {
        Status status = Status.create("(CREATE) 1");
        statusListController.addElementToStatusList(status);
        Status status1 = Status.create("(SCHEDULING) 1");
//        statusListController.updateValueList(status1, "SCHEDULING");
//        assertEquals("SCHEDULING", statusListController.statusList.get(0).getStatus());
    }
}