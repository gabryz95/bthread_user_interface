package gui.event.myDateEvent;

import gui.model.date.MyData;
import lombok.Getter;

@Getter
public abstract class MyDataEvent {

    protected MyData data;
}
