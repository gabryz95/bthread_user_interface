package gui.event.myDateEvent;

import gui.model.date.MyDataFactory;

public class LockEvent extends MyDataEvent {

    public static MyDataEvent create(String line) {

        if (line == null)
            return null;

        MyDataEvent lockEvent = new LockEvent();
        lockEvent.data = MyDataFactory.create("Lock", line);

        return lockEvent;
    }

}
