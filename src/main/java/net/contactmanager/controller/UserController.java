package net.contactmanager.controller;

import net.contactmanager.domain.User;
import net.contactmanager.domain.UserRoles;
import net.contactmanager.service.ServiceUser;
import net.contactmanager.service.ServiceUserRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Qualifier("serviceUser")
    @Autowired
    private ServiceUser serviceUser;

    @Qualifier("serviceUserRoles")
    @Autowired
    private ServiceUserRoles serviceUserRoles;


    @RequestMapping(value = "addUser", method = RequestMethod.POST)
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

}
