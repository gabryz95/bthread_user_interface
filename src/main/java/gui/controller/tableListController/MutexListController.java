package gui.controller.tableListController;

import gui.controller.ManageQueue;
import gui.model.date.Mutex;
import gui.view.MainWindowView;


import java.util.List;

public class MutexListController extends ManageQueue {
    private List<Mutex> mutexList;

    public static MutexListController create(List<Mutex> mutexList) {

        if (mutexList == null)
            return null;

        MutexListController mutexListController = new MutexListController();
        mutexListController.mutexList = mutexList;
        return mutexListController;
    }

    public void controll(Mutex mutex) {
        if (mutex.getStatus().equalsIgnoreCase("MUTACQUIRE")) {
            mutacuireFunction(mutex);
        } else if (mutex.getStatus().equalsIgnoreCase("MUTRELEASE")) {
            mutreleaseFunction(mutex);
        }
    }

    protected void mutacuireFunction(Mutex mutex) {
        for (Mutex element : mutexList) {
            if (element.getAddress().equalsIgnoreCase(mutex.getAddress())) {
                if (element.getThreadId() == mutex.getThreadId())
                    return;
                element.setQueue(addElement(element.getQueue(), mutex.getThreadId()));
                reloadData();
                return;
            }
        }
        mutexList.add(mutex);
    }

    protected void mutreleaseFunction(Mutex mutex) {
        final int size = mutexList.size();
        for (int i = 0; i < size; i++) {
            Mutex element = mutexList.get(i);
            if (element.getAddress().equalsIgnoreCase(mutex.getAddress())) {
                if (element.getThreadId() == mutex.getThreadId()) {
                    if (element.getQueue().isEmpty())
                        mutexList.remove(i);
                    else {
                        element.setQueue(calculateNewQueue(element.getQueue()));
                    }
                    reloadData();
                }
            }
        }
    }

    private void reloadData() {
        MainWindowView.mutexTable.getTableView().refresh(); //TODO: da sistemare
    }
}
