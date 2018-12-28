package gui.model;

import javafx.beans.property.SimpleStringProperty;

public class Lock {
    private final SimpleStringProperty thread;
    private final SimpleStringProperty lockStatus;

    public Lock(String thread, String lockStatus){
        this.thread = new SimpleStringProperty(thread);
        this.lockStatus = new SimpleStringProperty(lockStatus);
    }

    public String getThread() {
        return thread.get();
    }

    public SimpleStringProperty threadProperty() {
        return thread;
    }

    public void setThread(String thread) {
        this.thread.set(thread);
    }

    public String getLockStatus() {
        return lockStatus.get();
    }

    public SimpleStringProperty lockStatusProperty() {
        return lockStatus;
    }

    public void setLockStatus(String lockStatus) {
        this.lockStatus.set(lockStatus);
    }
}
