package com.organicgarden.service;

import com.organicgarden.model.Action;
import com.organicgarden.model.Plant;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface PlantService {

    void savePlant(Plant plant, HttpServletRequest httpServletRequest);

    List<Plant> getAvailablePlants();

    Plant getPlantById(Long id);

    void updatePlant(Plant plant, HttpServletRequest httpServletRequest);

    List<Plant> getAllPlantsForUserId(Long id);

    List<Action> getAllActionsForPlantId(Long id);

}
