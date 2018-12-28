package gui.event;

import gui.model.Bthread;

public class BarrierBlockedEvent {
    private final Bthread bthread;

    public BarrierBlockedEvent(Bthread bthread) {
        this.bthread = bthread;
    }

    public Bthread getBthread() {
        return bthread;
    }
}
