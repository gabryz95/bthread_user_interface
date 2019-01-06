package gui.event;

public class NotPauseEvent {
    private String fileName;

    public NotPauseEvent(String fileName) {
        this.fileName = fileName;
    }

    public String getString() {
        return "Not Pause process: " + fileName;
    }
}
