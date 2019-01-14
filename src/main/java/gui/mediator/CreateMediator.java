package gui.mediator;

import gui.controller.tableListController.*;
import gui.event.myDateEvent.*;
import gui.model.date.*;
import gui.model.date.datemodel.*;
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

    public static CreateMediator create(StatusModel statusModel, LockModel lockModel, MutexModel mutexModel, SemaphoreModel semaphoreModel,
                                        BarrierModel barrierModel, ConditionModel conditionModel) {

        if (statusModel == null)
            return null;
        if (lockModel == null)
            return null;
        if (mutexModel == null)
            return null;
        if (semaphoreModel == null)
            return null;
        if (barrierModel == null)
            return null;
        if (conditionModel == null)
            return null;

        CreateMediator createMediator = new CreateMediator();
        createMediator.statusListController = StatusListController.create(statusModel);
        createMediator.lockListController = LockListController.create(lockModel);
        createMediator.mutexListController = MutexListController.create(mutexModel);
        createMediator.semaphoreListController = SemaphoreListController.create(semaphoreModel);
        createMediator.barrierListController = BarrierListController.create(barrierModel);
        createMediator.conditionListController = ConditionListController.create(conditionModel);
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
        } else if (event instanceof GanttEvent) {
            //gantListController.controll((Status) ((StatusEvent) event).getData());
        }
    }
}
