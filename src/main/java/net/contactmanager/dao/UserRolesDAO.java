package net.contactmanager.dao;

import net.contactmanager.domain.UserRoles;

import java.util.List;

public interface UserRolesDAO {

    public void addUserRoles(UserRoles userRoles);
    public List<UserRoles> listUserRoles();
    public void removeUserRoles(Integer id);
}
