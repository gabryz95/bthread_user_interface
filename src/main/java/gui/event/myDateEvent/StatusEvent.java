package gui.event.myDateEvent;

import gui.model.date.MyDataFactory;

public class StatusEvent extends MyDataEvent {

    public static StatusEvent create(String line) {

        if (line == null)
            return null;

        StatusEvent statusEvent = new StatusEvent();
        statusEvent.data = MyDataFactory.create("Status", line);
        return statusEvent;
    }
}
