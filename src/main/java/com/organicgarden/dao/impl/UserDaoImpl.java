package com.organicgarden.dao.impl;

import com.organicgarden.dao.UserDao;
import com.organicgarden.model.Achievment;
import com.organicgarden.model.Plant;
import com.organicgarden.model.User;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Danylo
 */
@Repository
public class UserDaoImpl extends AbstractDaoImpl<User, String> implements
		UserDao {
	protected UserDaoImpl() {
		super(User.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		String hql = "SELECT u FROM User u";
		Query query = getCurrentSession().createQuery(hql);
		List<User> users = query.list();
		return users;
	}

    @Override
    public User getUserById(Long id) {
        String hql = "SELECT u FROM User u WHERE u.id=:id";
        Query query = getCurrentSession().createQuery(hql);
        query.setLong("id", id);
        List<User> users = query.list();
        if (!users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        String hql = "SELECT u FROM User u WHERE u.email=:email";
        Query query = getCurrentSession().createQuery(hql);
        query.setString("email", email);
        List<User> users = query.list();
        if (!users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public List<Achievment> getAchievments(Long id) {
        String hql = "SELECT DISTINCT a FROM User u JOIN u.achievments a WHERE a.user=:userId";
        Query query = getCurrentSession().createQuery(hql);
        query.setLong("userId", id);
        return query.list();
    }

    @Override
    public List<Plant> getPlants(Long id) {
        String hql = "SELECT DISTINCT p FROM User u JOIN u.plants p WHERE p.user=:userId";
        Query query = getCurrentSession().createQuery(hql);
        query.setLong("userId", id);
        return query.list();
    }

    @Override
    public int getRating(Long id) {
        String hql = "SELECT DISTINCT u.points FROM User u WHERE u.id=:userId";
        Query query = getCurrentSession().createQuery(hql);
        query.setLong("userId", id);
        List<Integer> ratings = query.list();
        if (!ratings.isEmpty()) {
            return ratings.get(0);
        }
        return 0;
    }
}
