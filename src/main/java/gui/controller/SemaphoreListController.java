package gui.controller;

import gui.model.date.Semaphore;
import gui.view.MainWindowView;
import javafx.collections.ObservableList;


public class SemaphoreListController extends ManageQueue {

    protected ObservableList<Semaphore> semaphoreList;

    public static SemaphoreListController create(ObservableList<Semaphore> semaphoreList) {

        if (semaphoreList == null)
            return null;

        SemaphoreListController semaphoreListController = new SemaphoreListController();
        semaphoreListController.semaphoreList = semaphoreList;
        return semaphoreListController;
    }

    public void controll(Semaphore semaphore) {
        if (semaphore.getStatus().equalsIgnoreCase("SEMWAIT")) {
            sewaitFunction(semaphore);
        } else if (semaphore.getStatus().equalsIgnoreCase("SEMACQUIRE")) {
            semacquireFunction(semaphore);
        } else if (semaphore.getStatus().equalsIgnoreCase("SEMPOST")) {
            sempostFunction(semaphore);
        }
    }

    public void sewaitFunction(Semaphore semaphore) {
        for (Semaphore item : semaphoreList) {
            if (item.getAddress().equals(semaphore.getAddress())) {
                if (item.getCounter() == 0)
                    item.setQueue(addElement(item.getQueue(), semaphore.getThreadId()));
                else
                    item.setCounter(item.getCounter() - 1);
                reloadData();
                return;
            }
        }
        if (semaphore.getCounter() == 0)
            semaphore.setQueue(String.valueOf(semaphore.getThreadId()));
        semaphoreList.add(semaphore);
    }

    public void semacquireFunction(Semaphore semaphore) {
        for (Semaphore item : semaphoreList) {
            if (item.getAddress().equals(semaphore.getAddress())) {
                if (!item.getQueue().isEmpty()) {
                    if (item.getCounter() > 0)
                        item.setCounter(item.getCounter() - 1);
                    item.setQueue(calculateNewQueue(item.getQueue()));
                }
                reloadData();
            }
        }
    }

    public void sempostFunction(Semaphore semaphore) {
        for (Semaphore item : semaphoreList) {
            if (item.getAddress().equalsIgnoreCase(semaphore.getAddress())) {
                item.setCounter(item.getCounter() + 1);
                reloadData();
                return;
            }
        }
        semaphore.setCounter(semaphore.getCounter() + 1);
        semaphoreList.add(semaphore);
    }

    private void reloadData() {
        MainWindowView.semaphoreTable.getTableView().refresh(); //TODO: da sistemare
    }
}
