package gui.event.myDateEvent;

import gui.model.date.MyDataFactory;

public class MutexEvent extends MyDataEvent {

    public static MyDataEvent create(String line) {

        if (line == null)
            return null;

        MyDataEvent mutexEvent = new MutexEvent();
        mutexEvent.data = MyDataFactory.create("Mutex", line);

        return mutexEvent;
    }
}
