package gui.event.myDateEvent;

import gui.model.date.MyDataFactory;

public class SemaphoreEvent extends MyDataEvent {

    public static MyDataEvent create(String line) {

        if (line == null)
            return null;

        MyDataEvent myDataEvent = new SemaphoreEvent();
        myDataEvent.data = MyDataFactory.create("Semaphore", line);
        return myDataEvent;
    }
}
