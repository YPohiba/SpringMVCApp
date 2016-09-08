package net.project.service;

import net.project.domain.UserRoles;

import java.util.List;

public interface ServiceUserRoles {

    public void addUserRoles(UserRoles userRoles);
    public List<UserRoles> listUserRoles();
    public void removeUserRoles(Integer id);
}
