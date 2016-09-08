package net.contactmanager.dao;

import net.contactmanager.domain.UserRoles;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRolesDAOImpl implements UserRolesDAO {


    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUserRoles(UserRoles userRoles) {
        sessionFactory.getCurrentSession().save(userRoles);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserRoles> listUserRoles() {
        return sessionFactory.getCurrentSession().createQuery("from UserRoles").list();
    }

    @Override
    public void removeUserRoles(Integer id) {
        UserRoles userRoles = (UserRoles)sessionFactory.getCurrentSession().get(UserRoles.class,id);
        if (userRoles != null)
            sessionFactory.getCurrentSession().delete(userRoles);
    }
}
