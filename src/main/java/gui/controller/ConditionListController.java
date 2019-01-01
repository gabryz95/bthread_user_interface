package gui.controller;

import gui.model.date.Condition;
import gui.view.MainWindowView;

import java.util.List;

public class ConditionListController extends ManageQueue {

    protected List<Condition> conditionList;

    public static ConditionListController create(List<Condition> conditionList) {

        if (conditionList == null)
            return null;

        ConditionListController conditionListController = new ConditionListController();
        conditionListController.conditionList = conditionList;
        return conditionListController;
    }

    public void controll(Condition condition) {
        String status = condition.getStatus();
        if (status.equalsIgnoreCase("CONDSIGNAL")) {
            condsignalFunction(condition);
        } else if (status.equalsIgnoreCase("CONDBROADCAST")) {
            condbroadcastFunction(condition);
        } else if (status.equalsIgnoreCase("CONDBLOCKED")) {
            condblockedFunction(condition);
        }
    }

    private void condblockedFunction(Condition condition) {
        for (Condition element : conditionList) {
            if (element.getAddress().equalsIgnoreCase(condition.getAddress())) {
                element.setQueue(addElement(element.getQueue(), condition.getThreadId()));
                reloadData();
                return;
            }
        }
        condition.setQueue(addElement(condition.getQueue(), condition.getThreadId()));
        conditionList.add(condition);
    }

    private void condbroadcastFunction(Condition condition) {
        for (Condition element : conditionList) {
            if (element.getAddress().equalsIgnoreCase(condition.getAddress())) {
                element.setQueue(null);
                reloadData();
            }
        }
    }

    private void condsignalFunction(Condition condition) {
        for (Condition element : conditionList) {
            if (element.getAddress().equalsIgnoreCase(condition.getAddress())) {
                element.setQueue(calculateNewQueue(element.getQueue()));
                reloadData();
            }
        }
    }

    private void reloadData() {
        MainWindowView.conditionTable.getTableView().refresh(); //TODO: da sistemare
    }
}
