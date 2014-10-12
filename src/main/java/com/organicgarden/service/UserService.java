package com.organicgarden.service;

import com.organicgarden.model.Achievment;
import com.organicgarden.model.Plant;
import com.organicgarden.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Danylo
 */
public interface UserService {

    void saveUser(User user, HttpServletRequest httpServletRequest);

    List<User> getAllUsers();

    User getUserById(Long id);

    User getUserByEmail(String email);

    void updateUser(User user, HttpServletRequest httpServletRequest);

    List<Achievment> getAchievments(Long id);

    List<Plant> getPlants(Long id);

    int getRating(Long id);
}
