package com.organicgarden.service.impl;


import com.organicgarden.dao.ActionDao;
import com.organicgarden.model.Action;
import com.organicgarden.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ActionServiceImpl implements ActionService{

    @Autowired
    private ActionDao actionDao;

    @Override
    public void saveAction(Action action) {
        actionDao.save(action);
    }

    @Override
    public void updateAction(Action action) {
        actionDao.saveOrUpdate(action);
    }

    @Override
    public List<Action> getActionsByPlantId(Long id) {
        return actionDao.getActionsByPlantId(id);
    }
}
