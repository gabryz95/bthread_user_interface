package gui.event.myDateEvent;

import gui.model.date.MyDataFactory;

public class ConditionEvent extends MyDataEvent {

    public static MyDataEvent create(String line) {

        if (line == null)
            return null;

        MyDataEvent myDataEvent = new ConditionEvent();
        myDataEvent.data = MyDataFactory.create("Condition", line);

        return myDataEvent;
    }
}
