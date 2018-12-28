package gui.mediator;

import gui.controller.MutexListController;
import gui.controller.SemaphoreListController;
import gui.event.MutexEvent;
import gui.event.SemaphoreEvent;
import gui.model.Mutex;
import gui.model.Semaphore;
import javafx.collections.ObservableList;
import lombok.Setter;

import java.util.Observable;
import java.util.Observer;

@Setter
public class CreateMediator implements Observer {


    protected MutexListController mutexListController;
    protected SemaphoreListController semaphoreListController;

    public static CreateMediator create(ObservableList<Mutex> mutexList, ObservableList<Semaphore> semaphoreList) {

        if (mutexList == null)
            return null;
        if (semaphoreList == null)
            return null;

        CreateMediator createMediator = new CreateMediator();
        createMediator.mutexListController = MutexListController.create(mutexList);
        createMediator.semaphoreListController = SemaphoreListController.create(semaphoreList);
        return createMediator;
    }

    @Override
    public void update(Observable o, Object event) {
        if (event instanceof MutexEvent) {
            mutexListController.controll((Mutex) ((MutexEvent) event).getData());
        } else if (event instanceof SemaphoreEvent) {
            semaphoreListController.controll((Semaphore) ((SemaphoreEvent) event).getData());
        }
    }
}
