package com.organicgarden.dao;

import com.organicgarden.model.Achievment;
import com.organicgarden.model.User;

import java.util.List;

public interface AchievmentDao extends AbstractDao<Achievment, String>{

    List<Achievment> getAchievmentsForUserId(Long id);

}
