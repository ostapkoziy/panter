package com.organicgarden.dao.impl;

import com.organicgarden.dao.ActionDao;
import com.organicgarden.model.Action;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActionDaoImpl extends AbstractDaoImpl<Action, String> implements ActionDao {

    protected ActionDaoImpl(){
        super(Action.class);
    }

    @Override
    public List<Action> getActionsByPlantId(Long id) {
        String hql = "SELECT a FROM Plant a JOIN a.User u WHERE u.ID=:id";
        Query query = getCurrentSession().createQuery(hql);
        query.setLong("id", id);
        return query.list();
    }
}
