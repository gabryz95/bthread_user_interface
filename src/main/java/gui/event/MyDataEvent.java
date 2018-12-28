package gui.event;

import gui.model.MyData;
import lombok.Getter;

@Getter
public abstract class MyDataEvent {

    protected MyData data;

}
