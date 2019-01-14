package gui.model.date.datemodel;

import gui.model.date.Gantt;
import gui.model.date.MyData;

import java.util.List;

public class GanttModel extends MyData {

    protected List<Gantt> ganttList;

    public static GanttModel create(List<Gantt> ganttList) {

        if (ganttList == null)
            return null;

        GanttModel ganttModel = new GanttModel();
        ganttModel.ganttList = ganttList;
        return ganttModel;
    }

    public void addElement(Gantt status) {
        ganttList.add(status);
    }

    public void deleteElement(int i) {
        ganttList.remove(i);
    }

    public void updateElementStatus(int i, String status) {
        ganttList.get(i).setStatus(status);
    }

    public int listSize() {
        return ganttList.size();
    }

    public Gantt getElementByIndex(int i) {
        return ganttList.get(i);
    }
}
