package com.organicgarden.dao.impl;


import com.organicgarden.dao.AchievmentDao;
import com.organicgarden.model.Achievment;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AchievmentDaoImpl extends AbstractDaoImpl<Achievment, String> implements AchievmentDao{

    protected AchievmentDaoImpl(){
        super(Achievment.class);
    }

    @Override
    public List<Achievment> getAchievmentsForUserId(Long id) {
        String hql = "SELECT a FROM Achievment a JOIN a.User u WHERE u.ID=:id";
        Query query = getCurrentSession().createQuery(hql);
        query.setLong("id", id);
        return query.list();
    }
}
