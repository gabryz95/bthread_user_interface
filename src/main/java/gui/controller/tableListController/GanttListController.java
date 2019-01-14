package gui.controller.tableListController;

import gui.event.GanttEventScheduling;
import gui.event.GanttThreadEvent;
import gui.model.date.Gantt;
import gui.model.date.datemodel.GanttModel;

import java.util.Observable;

public class GanttListController extends Observable {

    protected GanttModel ganttModel;

    public static GanttListController create(GanttModel ganttModel) {

        if (ganttModel == null)
            return null;

        GanttListController ganttListController = new GanttListController();
        ganttListController.ganttModel = ganttModel;
        return ganttListController;
    }

    public void controll(Gantt gantt) {
        if (gantt != null) {
            String statusValue = gantt.getStatus();
            if (statusValue.equalsIgnoreCase("CREATE")) {
                addElementToStatusList(gantt);
            } else if (statusValue.equalsIgnoreCase("SCHEDULING")) {
                this.setChanged();
                notifyObservers(new GanttThreadEvent(ganttModel.listSize()));
                updateValueList(gantt, statusValue);
                this.setChanged();
                notifyObservers(new GanttEventScheduling(gantt.getThreadId()));
            }
//            } else {
//                this.setChanged();
//                notifyObservers(new GanttThreadEvent(ganttModel.listSize()));
//                updateValueList(gantt, statusValue);
//            }
        }
    }

    protected void updateValueList(Gantt gantt, String value) {
        for (int i = 0; i < ganttModel.listSize(); i++) {
            Gantt element = ganttModel.getElementByIndex(i);
            if (element.getThreadId() == gantt.getThreadId()) {
                ganttModel.updateElementStatus(i, value);
            }
        }
    }

    protected void addElementToStatusList(Gantt gantt) {
        ganttModel.addElement(gantt);
    }


}
