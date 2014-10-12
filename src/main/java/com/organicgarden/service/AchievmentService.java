package com.organicgarden.service;

import com.organicgarden.model.Achievment;

import java.util.List;

public interface AchievmentService {

    void saveAchievment(Achievment achievment);

    void updateAchievment(Achievment achievment);

    List<Achievment> getAchievmentsForUserId(Long id);
}
