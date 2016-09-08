package net.project.dao;

import net.project.domain.UserRoles;

import java.util.List;

public interface UserRolesDAO {

    public void addUserRoles(UserRoles userRoles);
    public List<UserRoles> listUserRoles();
    public void removeUserRoles(Integer id);
}
