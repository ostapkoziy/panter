package com.organicgarden.service.impl;

import com.organicgarden.dao.PlantDao;
import com.organicgarden.model.Action;
import com.organicgarden.model.Plant;
import com.organicgarden.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@Transactional
public class PlantServiceImpl implements PlantService{

    @Autowired
    private PlantDao plantDao;

    @Override
    public void savePlant(Plant plant, HttpServletRequest httpServletRequest) {
        plantDao.save(plant);
    }

    @Override
    public List<Plant> getAvailablePlants() {
        return plantDao.getAvailablePlants();
    }

    @Override
    public Plant getPlantById(Long id) {
        return plantDao.getPlantById(id);
    }

    @Override
    public void updatePlant(Plant plant, HttpServletRequest httpServletRequest) {
        plantDao.saveOrUpdate(plant);
    }

    @Override
    public List<Plant> getAllPlantsForUserId(Long id) {
        return plantDao.getAllPlantsForUserId(id);
    }

    @Override
    public List<Action> getAllActionsForPlantId(Long id) {
        return plantDao.getActionsForPlantId(id);
    }
}
