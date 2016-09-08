package net.contactmanager.service;

import net.contactmanager.domain.UserRoles;

import java.util.List;

public interface ServiceUserRoles {

    public void addUserRoles(UserRoles userRoles);
    public List<UserRoles> listUserRoles();
    public void removeUserRoles(Integer id);
}
