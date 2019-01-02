package gui.controller.tableListController;

import gui.model.date.Condition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ConditionListControllerTest {

    private ConditionListController conditionListController;
    private ConditionListController conditionListController1;
    private ObservableList<Condition> conditionObservableList;

    @BeforeEach
    public void setUp() {
        conditionObservableList = FXCollections.observableArrayList(new ArrayList<>());
        conditionListController = ConditionListController.create(conditionObservableList);
        conditionListController1 = Mockito.mock(ConditionListController.class);
    }

    @Test
    public void create01() {
        assertNull(ConditionListController.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(conditionListController);
    }


    @Test
    public void controll01() {
        Condition condition = Mockito.mock(Condition.class);
        conditionListController1.controll(condition);
        Mockito.verify(conditionListController1, Mockito.times(1)).controll(condition);
    }

    @Test
    public void controll02() {
        Condition condition = Condition.create("(CONDSIGNAL) 2 0x10f8760b8");
        conditionListController1.condsignalFunction(condition);
        Mockito.verify(conditionListController1, Mockito.times(1)).condsignalFunction(condition);
    }

    @Test
    public void controll03() {
        Condition condition = Condition.create("(CONDBROADCAST) 2 0x10f8760b0");
        conditionListController1.condbroadcastFunction(condition);
        Mockito.verify(conditionListController1, Mockito.times(1)).condbroadcastFunction(condition);
    }

    @Test
    public void controll04() {
        Condition condition = Condition.create("(CONDBLOCKED) 2 0x10f8760b0");
        conditionListController1.condblockedFunction(condition);
        Mockito.verify(conditionListController1, Mockito.times(1)).condblockedFunction(condition);
    }

    @Test
    void condblockedFunction01() {
        Condition condition = Condition.create("(CONDBLOCKED) 2 0x10f8760b0");
        conditionListController.condblockedFunction(condition);
        assertEquals("2", conditionListController.conditionList.get(0).getQueue());
    }

    @Test
    void condblockedFunction02() {
        Condition condition = Condition.create("(CONDBLOCKED) 2 0x10f8760b0");
        conditionListController.condblockedFunction(condition);
        Condition condition1 = Condition.create("(CONDBLOCKED) 3 0x10f8760b0");
//        conditionListController.condblockedFunction(condition1);
//        assertEquals("2 , 3", conditionListController.conditionList.get(0).getQueue());
    }

    @Test
    void condbroadcastFunction() {
        Condition condition = Condition.create("(CONDBLOCKED) 2 0x10f8760b0");
        conditionListController.condblockedFunction(condition);
        Condition condition1 = Condition.create("(CONDBROADCAST) 2 0x10f8760b0");
//        conditionListController.condbroadcastFunction(condition1);
//        assertEquals(null, conditionListController.conditionList.get(0).getQueue());
    }

    @Test
    void condsignalFunction() {
        Condition condition = Condition.create("(CONDBLOCKED) 2 0x10f8760b0");
        conditionListController.condblockedFunction(condition);
        Condition condition1 = Condition.create("(CONDSIGNAL) 2 0x10f8760b0");
//        conditionListController.condsignalFunction(condition1);
//        assertEquals("", conditionListController.conditionList.get(0).getQueue());
    }
}