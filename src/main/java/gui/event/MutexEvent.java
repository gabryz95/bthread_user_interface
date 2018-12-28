package gui.event;

import gui.model.MyDataFactory;

public class MutexEvent extends MyDataEvent {

    public static MutexEvent create(String line) {

        if (line == null)
            return null;

        MutexEvent mutexEvent = new MutexEvent();
        //mutexEvent.mutex = Mutex.create(line);
        mutexEvent.data = MyDataFactory.create("Mutex", line);

        return mutexEvent;
    }
}
