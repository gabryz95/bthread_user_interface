package gui.mediator;

import gui.controller.BarrierListController;
import gui.controller.ConditionListController;
import gui.controller.MutexListController;
import gui.controller.SemaphoreListController;
import gui.event.BarrierEvent;
import gui.event.ConditionEvent;
import gui.event.MutexEvent;
import gui.event.SemaphoreEvent;
import gui.model.date.Barrier;
import gui.model.date.Condition;
import gui.model.date.Mutex;
import gui.model.date.Semaphore;
import javafx.collections.ObservableList;
import lombok.Setter;

import java.util.Observable;
import java.util.Observer;

@Setter
public class CreateMediator implements Observer {


    protected MutexListController mutexListController;
    protected SemaphoreListController semaphoreListController;
    protected BarrierListController barrierListController;
    protected ConditionListController conditionListController;

    public static CreateMediator create(ObservableList<Mutex> mutexList, ObservableList<Semaphore> semaphoreList,
                                        ObservableList<Barrier> barrierList, ObservableList<Condition> conditionList) {

        if (mutexList == null)
            return null;
        if (semaphoreList == null)
            return null;
        if (barrierList == null)
            return null;
        if (conditionList == null)
            return null;

        CreateMediator createMediator = new CreateMediator();
        createMediator.mutexListController = MutexListController.create(mutexList);
        createMediator.semaphoreListController = SemaphoreListController.create(semaphoreList);
        createMediator.barrierListController = BarrierListController.create(barrierList);
        createMediator.conditionListController = ConditionListController.create(conditionList);
        return createMediator;
    }

    @Override
    public void update(Observable o, Object event) {
        if (event instanceof MutexEvent) {
            mutexListController.controll((Mutex) ((MutexEvent) event).getData());
        } else if (event instanceof SemaphoreEvent) {
            semaphoreListController.controll((Semaphore) ((SemaphoreEvent) event).getData());
        } else if (event instanceof BarrierEvent) {
            barrierListController.controll((Barrier) ((BarrierEvent) event).getData());
        } else if (event instanceof ConditionEvent) {
            conditionListController.controll((Condition) ((ConditionEvent) event).getData());
        }
    }
}
