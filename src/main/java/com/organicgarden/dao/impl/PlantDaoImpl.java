package com.organicgarden.dao.impl;


import com.organicgarden.dao.PlantDao;
import com.organicgarden.model.Action;
import com.organicgarden.model.Plant;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlantDaoImpl extends AbstractDaoImpl<Plant, String> implements PlantDao{

    protected PlantDaoImpl() {
        super(Plant.class);
    }

    @Override
    public List<Plant> getAvailablePlants() {
        String hql = "SELECT p FROM Plant p GROUP BY p.name";
        Query query = getCurrentSession().createQuery(hql);
        List<Plant> plants = query.list();
        return plants;
    }


    @Override
    public Plant getPlantById(Long id) {
        String hql = "SELECT p FROM Plant p WHERE p.id=:id";
        Query query = getCurrentSession().createQuery(hql);
        query.setLong("id", id);
        List<Plant> plants = query.list();
        if (!plants.isEmpty()) {
            return plants.get(0);
        }
        return null;
    }

    @Override
    public List<Plant> getAllPlantsForUserId(Long id) {
        String hql = "SELECT p FROM Plant p JOIN p.User u WHERE u.ID=:id";
        Query query = getCurrentSession().createQuery(hql);
        query.setLong("id", id);
        return query.list();
    }

    @Override
    public List<Action> getActionsForPlantId(Long id) {
        String hql = "SELECT DISTINCT a FROM Plant p JOIN p.actionList a WHERE a.plant=:userId";
        Query query = getCurrentSession().createQuery(hql);
        query.setLong("userId", id);
        return query.list();
    }
}
