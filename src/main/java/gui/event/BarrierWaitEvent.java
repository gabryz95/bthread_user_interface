package gui.event;

import gui.model.Bthread;

public class BarrierWaitEvent {
    private final Bthread bthread;

    public BarrierWaitEvent(Bthread bthread) {
        this.bthread = bthread;
    }

    public Bthread getBthread() {
        return bthread;
    }
}
