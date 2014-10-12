package com.organicgarden.dao;

import com.organicgarden.model.Achievment;
import com.organicgarden.model.Plant;
import com.organicgarden.model.User;

import java.util.List;

public interface UserDao extends AbstractDao<User, String> {

    List<User> getAllUsers();

    User getUserById(Long id);

    User getUserByEmail(String email);

    List<Achievment> getAchievments(Long id);

    List<Plant> getPlants(Long id);

    int getRating(Long id);
}
