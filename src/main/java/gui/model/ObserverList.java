package gui.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class ObserverList {

    private final List<Observer> observers = new ArrayList<>();

    public ObserverList() {
    }

    public void add(final Observer o) {
        observers.add(o);
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public int size() {
        return observers.size();
    }

    public Observer getObserver(final int position) {
        if (position < 0 || position >= observers.size())
            return null;
        return observers.get(position);
    }
}
