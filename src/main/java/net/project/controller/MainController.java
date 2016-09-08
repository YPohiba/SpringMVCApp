package net.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = {"/", "/index"})
    public String home(Model model){
        return "/index";
    }

    @RequestMapping("/error403")
    public String error403(Model model){
        return "error403";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationPage(Model model){

        return "/registration";
    }

}
