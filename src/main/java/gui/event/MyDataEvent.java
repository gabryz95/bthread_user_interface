package gui.event;

import gui.model.date.MyData;
import lombok.Getter;

@Getter
public abstract class MyDataEvent {

    protected MyData data;
}
