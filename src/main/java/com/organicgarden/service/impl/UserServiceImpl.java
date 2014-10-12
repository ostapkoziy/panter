package com.organicgarden.service.impl;

import com.organicgarden.dao.UserDao;
import com.organicgarden.model.Achievment;
import com.organicgarden.model.Plant;
import com.organicgarden.model.User;
import com.organicgarden.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Danylo
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private static final Logger log = Logger.getLogger(UserServiceImpl.class);
    @Autowired
    UserDao userDao;

    @Override
    public void saveUser(User user, HttpServletRequest httpServletRequest) {
        log.info("Save user with email = " + user.getEmail());
        userDao.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        log.info("Getting all users");
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public void updateUser(User user, HttpServletRequest httpServletRequest) {
        log.info("Updating user with email " + user.getEmail());
        User persistedUser = userDao.getUserByEmail(user.getEmail());
        userDao.saveOrUpdate(persistedUser);
    }

    @Override
    public List<Achievment> getAchievments(Long id) {
        return userDao.getAchievments(id);
    }

    @Override
    public List<Plant> getPlants(Long id) {
        return userDao.getPlants(id);
    }

    @Override
    public int getRating(Long id) {
        return userDao.getRating(id);
    }
}
