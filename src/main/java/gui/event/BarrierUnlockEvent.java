package gui.event;

import gui.model.Bthread;

public class BarrierUnlockEvent {
    private final Bthread bthread;

    public BarrierUnlockEvent(Bthread bthread) {
        this.bthread = bthread;
    }

    public Bthread getBthread() {
        return bthread;
    }
}
