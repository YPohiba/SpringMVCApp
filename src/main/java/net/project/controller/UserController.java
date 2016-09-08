package net.project.controller;

import net.project.domain.User;
import net.project.domain.UserRoles;
import net.project.service.ServiceUser;
import net.project.service.ServiceUserRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class UserController {

    @Qualifier("serviceUser")
    @Autowired
    private ServiceUser serviceUser;

    @Qualifier("serviceUserRoles")
    @Autowired
    private ServiceUserRoles serviceUserRoles;


    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(Model model, @ModelAttribute("user")User user){

        if (user.getUsername().isEmpty() || user.getPassword().isEmpty() || user.getEmail().isEmpty()) {
            model.addAttribute("error_message", "Error. Fill in all the fields.");
        } else{
            if (serviceUser.getUser(user.getUsername()) != null) {
                model.addAttribute("error_message", "Error. A person with this name already exists.");
            } else {
                UserRoles userRoles = new UserRoles(user.getUsername(),"ROLE_USER");
                user.setEnabled(true);
                serviceUser.addUser(user);
                serviceUserRoles.addUserRoles(userRoles);
                model.addAttribute("reg_message", "Registration completed successfully.");
            }
        }
        return "/registration";
    }

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.POST)
    public String getAllUsers(Map<String, Object> map){

        map.put("user", new User());
        map.put("userList", serviceUser.listUsers());

        return "/index";
    }

    @RequestMapping(value = "/deleteUser/{username}")
    public String deleteUser(Model model, @PathVariable("username") String username){

        serviceUser.removeUser(username);

        return "/index";
    }

}
