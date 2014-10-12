package com.organicgarden.dao;

import com.organicgarden.model.Action;
import com.organicgarden.model.User;

import java.util.List;

public interface ActionDao extends AbstractDao<Action, String>{

    List<Action> getActionsByPlantId(Long id);
}
