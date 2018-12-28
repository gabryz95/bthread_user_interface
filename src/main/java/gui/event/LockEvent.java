package gui.event;

import gui.model.Bthread;

public class LockEvent {

    private Bthread bthread;

    public LockEvent(final Bthread bthread) {
        this.bthread = bthread;
    }

    public Bthread getBthread() {
        return bthread;
    }
}
