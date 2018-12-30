package gui.controller;

import gui.model.date.Condition;

import java.util.List;

public class ConditionListController {

    protected List<Condition> conditionList;

    public static ConditionListController create(List<Condition> conditionList) {

        if (conditionList == null)
            return null;

        ConditionListController conditionListController = new ConditionListController();
        conditionListController.conditionList = conditionList;
        return conditionListController;
    }

    public void controll(Condition condition) {

    }
}
