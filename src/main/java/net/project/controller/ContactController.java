package net.project.controller;

import net.project.domain.Contact;
import net.project.service.ServiceContact;
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
public class ContactController {

    @Qualifier("ServiceContact")
    @Autowired
    private ServiceContact serviceContact;

    @RequestMapping("/contact")
    public String listContacts(Map<String, Object> map){

        map.put("contact", new Contact());
        map.put("contactList", serviceContact.listContacts());

        return "contact";
    }

    @RequestMapping("/delete/{contactId}")
    public String deleteContact(@PathVariable("contactId") Integer contactId) {

        serviceContact.removeContact(contactId);

        return "/index";
    }

    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public String addContact(Model model, @ModelAttribute("contact") Contact contact){

        if (!contact.getFirstname().isEmpty() && !contact.getEmail().isEmpty()
                && !contact.getLastname().isEmpty() && !contact.getTelephone().isEmpty()) {
            serviceContact.addContact(contact);
        } else {
            model.addAttribute("message", "Error. Fill in all the fields.");
        }

        return "contact";
    }
}
