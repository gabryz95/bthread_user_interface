package gui.event.myDateEvent;

import gui.model.date.MyDataFactory;

public class BarrierEvent extends MyDataEvent {

    public static MyDataEvent create(String line) {

        if (line == null)
            return null;

        MyDataEvent myDataEvent = new BarrierEvent();
        myDataEvent.data = MyDataFactory.create("Barrier", line);

        return myDataEvent;
    }
}
