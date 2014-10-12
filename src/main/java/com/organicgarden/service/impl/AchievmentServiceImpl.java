package com.organicgarden.service.impl;

import com.organicgarden.dao.AchievmentDao;
import com.organicgarden.model.Achievment;
import com.organicgarden.service.AchievmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AchievmentServiceImpl implements AchievmentService{

    @Autowired
    private AchievmentDao achievmentDao;

    @Override
    public void saveAchievment(Achievment achievment) {
        achievmentDao.save(achievment);
    }

    @Override
    public void updateAchievment(Achievment achievment) {
        achievmentDao.saveOrUpdate(achievment);
    }

    @Override
    public List<Achievment> getAchievmentsForUserId(Long id) {
        return achievmentDao.getAchievmentsForUserId(id);
    }
}
