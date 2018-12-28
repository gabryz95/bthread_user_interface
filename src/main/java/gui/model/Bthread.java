package gui.model;


public class Bthread {
    private int pid;
    private String memory = null;
    private String status = null;

    public Bthread(final int pid) {
        this.pid = pid;
    }

    public Bthread() {

    }

    public Bthread(final int pid, final String memory, final String status){
        this.pid = pid;
        this.memory = memory;
        this.status = status;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
