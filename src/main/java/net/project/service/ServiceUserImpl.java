package net.project.service;

import net.project.dao.UserDAO;
import net.project.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "serviceUser")
public class ServiceUserImpl implements ServiceUser{

    @Autowired
    private UserDAO userDAO;

    @Transactional
    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Transactional
    @Override
    public List<User> listUsers() {
        return userDAO.listUsers();
    }

    @Transactional
    @Override
    public void removeUser(String id) {
        userDAO.removeUser(id);
    }

    @Transactional
    @Override
    public User getUser(String id) {
        return userDAO.getUser(id);
    }
}
