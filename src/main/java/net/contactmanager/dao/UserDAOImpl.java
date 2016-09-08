package net.contactmanager.dao;

import net.contactmanager.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> listUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    @Override
    public void removeUser(String id) {
        User user = (User)sessionFactory.getCurrentSession().get(User.class,id);
        if (user != null)
            sessionFactory.getCurrentSession().delete(user);

    }

    @Override
    public User getUser(String id) {

        User user = (User)sessionFactory.getCurrentSession().get(User.class,id);

        return user;
    }
}
