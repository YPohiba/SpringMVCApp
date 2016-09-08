package net.contactmanager.dao;

import net.contactmanager.domain.User;

import java.util.List;

public interface UserDAO {

    public void addUser(User user);
    public List<User> listUsers();
    public void removeUser(String id);
    public User getUser(String id);
}
