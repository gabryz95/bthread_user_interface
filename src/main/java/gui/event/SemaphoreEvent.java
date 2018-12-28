package gui.event;

import gui.model.MyDataFactory;

public class SemaphoreEvent extends MyDataEvent {

    public static SemaphoreEvent create(String line) {

        if (line == null)
            return null;

        SemaphoreEvent semaphoreEvent = new SemaphoreEvent();
        //semaphoreEvent.semaphore = Semaphore.create(line);
        semaphoreEvent.data = MyDataFactory.create("Semaphore", line);
        return semaphoreEvent;
    }
}
