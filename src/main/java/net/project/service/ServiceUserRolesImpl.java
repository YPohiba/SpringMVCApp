package net.project.service;

import net.project.dao.UserRolesDAO;
import net.project.domain.UserRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "serviceUserRoles")
public class ServiceUserRolesImpl implements ServiceUserRoles{

    @Autowired
    private UserRolesDAO userRolesDAO;

    @Transactional
    @Override
    public void addUserRoles(UserRoles userRoles) {
        userRolesDAO.addUserRoles(userRoles);
    }

    @Transactional
    @Override
    public List<UserRoles> listUserRoles() {
        return userRolesDAO.listUserRoles();
    }

    @Transactional
    @Override
    public void removeUserRoles(Integer id) {
        userRolesDAO.removeUserRoles(id);
    }
}
