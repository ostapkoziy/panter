package com.organicgarden.service;

import com.organicgarden.model.Action;

import java.util.List;

public interface ActionService {

    void saveAction(Action action);

    void updateAction(Action action);

    List<Action> getActionsByPlantId(Long id);
}
