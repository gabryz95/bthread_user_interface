package gui.controller.tableListController;

import gui.model.date.Barrier;
import gui.view.MainWindowView;

import java.util.List;

//TODO: possibilità di utilizzo dello strategi pattern/state
public class BarrierListController extends ManageQueue {

    protected List<Barrier> barrierList;

    public static BarrierListController create(List<Barrier> barrierList) {
        if (barrierList == null)
            return null;

        BarrierListController barrierListController = new BarrierListController();
        barrierListController.barrierList = barrierList;
        return barrierListController;
    }

    public void controll(Barrier barrier) {
        String status = barrier.getStatus();
        if (status.equalsIgnoreCase("BARRIERWAIT")) {
            barrierWaitfunction(barrier);
        } else if (status.equalsIgnoreCase("BARRIERUNLOCK")) {
            barrierUnlockFunction(barrier);
        }

    }

    protected void barrierUnlockFunction(Barrier barrier) {
        for (Barrier element : barrierList) {
            if (element.getAddress().equalsIgnoreCase(barrier.getAddress())) {
                if (barrier.getSize() == barrier.getCounter()) {
                    element.setQueue(null);
                    element.setCounter(0);
                    reloadData();
                }
            }
        }

    }


    protected void barrierWaitfunction(Barrier barrier) {
        for (Barrier element : barrierList) {
            if (element.getAddress().equalsIgnoreCase(barrier.getAddress())) {
                element.setCounter(barrier.getCounter());
                element.setQueue(addElement(element.getQueue(), barrier.getThreadId()));
                reloadData();
                return;
            }
        }
        barrierList.add(barrier);
    }

    private void reloadData() {
        MainWindowView.barrierTable.getTableView().refresh(); //TODO: da sistemare
    }
}
