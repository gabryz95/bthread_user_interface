package gui.event.myDateEvent;

import gui.model.date.MyDataFactory;

public class GanttEvent extends MyDataEvent {

    public static GanttEvent create(String line) {

        if (line == null)
            return null;

        GanttEvent ganttEvent = new GanttEvent();
        ganttEvent.data = MyDataFactory.create("Gantt", line);
        return ganttEvent;
    }
}
