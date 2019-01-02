package gui.controller.tableListController;

import gui.model.date.Lock;
import gui.view.MainWindowView;

import java.util.List;

public class LockListController {

    protected List<Lock> lockList;

    public static LockListController create(List<Lock> lockList) {

        if (lockList == null)
            return null;

        LockListController lockListController = new LockListController();
        lockListController.lockList = lockList;
        return lockListController;
    }

    public void controll(Lock lock) {
        if (lock != null) {
            for (Lock element : lockList) {
                if (element.getThreadId() == lock.getThreadId()) {
                    removeLockStatuFromElement();
                    element.setStatus("LOCK");
                    reloadData();
                    return;
                }
            }
            lock.setStatus("LOCK");
            addElementToLockList(lock);
            removeLockStatuFromElement();
        }
    }

    protected void removeLockStatuFromElement() {
        for (Lock element2 : lockList) {
            try {
                if (element2.getStatus().equalsIgnoreCase("LOCK"))
                    element2.setStatus(null);
            } catch (NullPointerException e) {
            }
        }
    }

    protected void addElementToLockList(Lock lock) {
        lockList.add(lock);
    }

    private void reloadData() {
        MainWindowView.lockTable.getTableView().refresh(); //TODO: da sistemare
    }
}
