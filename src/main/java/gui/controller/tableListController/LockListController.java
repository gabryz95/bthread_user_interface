package gui.controller.tableListController;

import gui.model.date.Lock;
import gui.model.date.datemodel.LockModel;
import gui.view.MainWindowView;

import java.util.List;

public class LockListController {

    protected LockModel lockModel;

    public static LockListController create(LockModel lockModel) {

        if (lockModel == null)
            return null;

        LockListController lockListController = new LockListController();
        lockListController.lockModel = lockModel;
        return lockListController;
    }

    public void controll(Lock lock) {
        if (lock != null) {
            for (int i = 0; i < lockModel.listSize(); i++) {
                Lock element = lockModel.getElementByIndex(i);
                if (element.getThreadId() == lock.getThreadId()) {
                    removeLockStatuFromElement();
                    lockModel.updateElementStatus(i, "LOCK");
                    reloadData();
                    return;
                }
            }
            lock.setStatus("LOCK");
            lockModel.addElement(lock);
            removeLockStatuFromElement();
        }
    }

    protected void removeLockStatuFromElement() {
        for (int i = 0; i < lockModel.listSize(); i++) {
            Lock element = lockModel.getElementByIndex(i);
            try {
                if (element.getStatus().equalsIgnoreCase("LOCK"))
                    lockModel.updateElementStatus(i, null);
            } catch (NullPointerException e) {
            }
        }
    }

    protected void reloadData() {
        MainWindowView.lockTable.getTableView().refresh();
    }
}
