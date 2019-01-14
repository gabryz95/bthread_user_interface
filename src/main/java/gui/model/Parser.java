package gui.model;

import gui.event.myDateEvent.MyDataEventFactory;

import java.util.Observable;

public class Parser extends Observable {
    public static Bthread parsing(String line) {
        Bthread bthread = new Bthread();

        if (line.toCharArray()[0] == '(') {
            String delims = "[ ]+";
            String[] tokens = line.split(delims);
            if (tokens.length == 1) {
                bthread.setStatus(tokens[0].substring(1, tokens[0].length() - 1));
            } else if (tokens.length == 2) {
                bthread.setPid(Integer.valueOf(tokens[1]));
                bthread.setStatus(tokens[0].substring(1, tokens[0].length() - 1));
            } else if (tokens.length == 3) {
                bthread.setPid(Integer.valueOf(tokens[1]));
                bthread.setStatus(tokens[0].substring(1, tokens[0].length() - 1));
                bthread.setMemory(tokens[2]);
            }
        }
        return bthread;
    }

    protected String StringMatching(String line) {

        String discriminated = line.substring(1, 4);
        String result = null;

        if (discriminated.equalsIgnoreCase("MUT")) {
            result = "Mutex";
        } else if (discriminated.equalsIgnoreCase("SEM")) {
            result = "Semaphore";
        } else if (discriminated.equalsIgnoreCase("BAR")) {
            result = "Barrier";
        } else if (discriminated.equalsIgnoreCase("CON")) {
            result = "Condition";
        }

        return result + "Event";
    }

    public void parsing2(String line) {

        if (line == null)
            return;

        if (!line.startsWith("("))
            return;

        String discriminated = line.substring(1, 4);

        if (discriminated.equalsIgnoreCase("MUT")) {
            this.setChanged();
            notifyObservers(MyDataEventFactory.create("MutexEvent", line));
        } else if (discriminated.equalsIgnoreCase("SEM")) {
            this.setChanged();
            notifyObservers(MyDataEventFactory.create("SemaphoreEvent", line));
        } else if (discriminated.equalsIgnoreCase("BAR")) {
            this.setChanged();
            notifyObservers(MyDataEventFactory.create("BarrierEvent", line));
        } else if (discriminated.equalsIgnoreCase("CON")) {
            this.setChanged();
            notifyObservers(MyDataEventFactory.create("ConditionEvent", line));
        } else if (discriminated.equalsIgnoreCase("SCH")) {
            this.setChanged();
            notifyObservers(MyDataEventFactory.create("LockEvent", line));
        }
        this.setChanged();
        notifyObservers(MyDataEventFactory.create("StatusEvent", line));
        this.setChanged();
        notifyObservers(MyDataEventFactory.create("GanttEvent", line));
    }

}
