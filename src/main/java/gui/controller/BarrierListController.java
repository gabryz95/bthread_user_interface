package gui.controller;

import gui.model.date.Barrier;

import java.util.List;

//TODO: possibilità di utilizzo dello strategi pattern/state
public class BarrierListController {

    private List<Barrier> barrierList;

    public static BarrierListController create(List<Barrier> barrierList) {
        if (barrierList == null)
            return null;

        BarrierListController barrierListController = new BarrierListController();
        barrierListController.barrierList = barrierList;
        return barrierListController;
    }

    public void controll(Barrier barrier) {

    }
}
