package gui.model.date;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public abstract class MyData {

    protected SimpleStringProperty address;
    protected SimpleIntegerProperty threadId;
    protected SimpleStringProperty status;

    public String getStatus() {
        return status.get();
    }

    public int getThreadId() {
        return threadId.get();
    }

    public String getAddress() {
        return address.get();
    }
}
