package com.organicgarden.dao;


import com.organicgarden.model.Action;
import com.organicgarden.model.Plant;

import java.util.List;

public interface PlantDao extends AbstractDao<Plant, String> {

    List<Plant> getAvailablePlants();

    List<Plant> getAllPlantsForUserId(Long id);

    Plant getPlantById(Long id);

    List<Action> getActionsForPlantId(Long id);
}
