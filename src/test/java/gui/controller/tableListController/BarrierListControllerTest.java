package gui.controller.tableListController;

import gui.controller.tableListController.BarrierListController;
import gui.model.date.Barrier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BarrierListControllerTest {

    private BarrierListController barrierListController;
    private ObservableList<Barrier> barrierObservableList;

    @BeforeEach
    public void setUp() {
        barrierObservableList = FXCollections.observableArrayList(new ArrayList<>());
        barrierListController = BarrierListController.create(barrierObservableList);
    }

    @Test
    public void create01() {
        assertNull(BarrierListController.create(null));
    }

    @Test
    public void create02() {
        assertNotNull(barrierListController);
    }

    @Test
    public void controll01() {
        Barrier barrier = Mockito.mock(Barrier.class);
        BarrierListController barrierListController1 = Mockito.mock(BarrierListController.class);
        barrierListController1.controll(barrier);
        Mockito.verify(barrierListController1, Mockito.times(1)).controll(barrier);
    }

    @Test
    public void controll02() {
        Barrier barrier = Barrier.create("(BARRIERWAIT) 9 0x10eb39198 8 9");
        BarrierListController barrierListController1 = Mockito.mock(BarrierListController.class);
        barrierListController1.barrierWaitfunction(barrier);
        Mockito.verify(barrierListController1, Mockito.times(1)).barrierWaitfunction(barrier);
    }

    @Test
    public void controll03() {
        Barrier barrier = Barrier.create("(BARRIERUNLOCK) 0x10eb39198 9 9");
        BarrierListController barrierListController1 = Mockito.mock(BarrierListController.class);
        barrierListController1.barrierUnlockFunction(barrier);
        Mockito.verify(barrierListController1, Mockito.times(1)).barrierUnlockFunction(barrier);
    }


    @Test
    public void barrierUnlockFunction() {
        Barrier barrierWait = Barrier.create("(BARRIERWAIT) 9 0x10eb39198 8 9");
        barrierListController.barrierWaitfunction(barrierWait);
        Barrier barrierUnlock = Barrier.create("(BARRIERUNLOCK) 0x10eb39198 9 9");
        //barrierListController.barrierUnlockFunction(barrierUnlock);
        //assertEquals(null, barrierListController.barrierList.get(0).getQueue());
    }

    @Test
    public void barrierWaitfunction01() {
        Barrier barrier = Barrier.create("(BARRIERWAIT) 8 0x10eb39198 7 9");
        barrierListController.barrierWaitfunction(barrier);
        assertEquals(1, barrierListController.barrierList.size());
    }

    @Test
    public void barrierWaitfunction02() {
        Barrier barrier = Barrier.create("(BARRIERWAIT) 8 0x10eb39198 7 9");
        barrierListController.barrierWaitfunction(barrier);
        Barrier barrier1 = Barrier.create("(BARRIERWAIT) 8 0x10eb39198 8 9");
//        barrierListController.barrierWaitfunction(barrier1);
//        assertEquals(8, barrierListController.barrierList.get(0).getCounter());
    }
}