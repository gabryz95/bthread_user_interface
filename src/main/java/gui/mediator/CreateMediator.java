package gui.mediator;

import gui.controller.tableListController.*;
import gui.event.myDateEvent.*;
import gui.model.date.*;
import javafx.collections.ObservableList;
import lombok.Setter;

import java.util.Observable;
import java.util.Observer;

@Setter
public class CreateMediator implements Observer {

    protected StatusListController statusListController;
    protected LockListController lockListController;
    protected MutexListController mutexListController;
    protected SemaphoreListController semaphoreListController;
    protected BarrierListController barrierListController;
    protected ConditionListController conditionListController;

    public static CreateMediator create(ObservableList<Status> statusList, ObservableList<Lock> lockList, ObservableList<Mutex> mutexList, ObservableList<Semaphore> semaphoreList,
                                        ObservableList<Barrier> barrierList, ObservableList<Condition> conditionList) {

        if (statusList == null)
            return null;
        if (lockList == null)
            return null;
        if (mutexList == null)
            return null;
        if (semaphoreList == null)
            return null;
        if (barrierList == null)
            return null;
        if (conditionList == null)
            return null;

        CreateMediator createMediator = new CreateMediator();
        createMediator.statusListController = StatusListController.create(statusList);
        createMediator.lockListController = LockListController.create(lockList);
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
        } else if (event instanceof StatusEvent) {
            statusListController.controll((Status) ((StatusEvent) event).getData());
        } else if (event instanceof LockEvent) {
            lockListController.controll((Lock) ((LockEvent) event).getData());
        }
    }
}
