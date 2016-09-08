package net.project.service;


import net.project.dao.ContactDAO;
import net.project.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "ServiceContact")
public class ServiceContactImpl implements ServiceContact {

    @Autowired
    private ContactDAO contactDAO;

    @Transactional
    @Override
    public void addContact(Contact contact) {
        contactDAO.addContact(contact);
    }

    @Transactional
    @Override
    public List<Contact> listContacts() {
        return contactDAO.listContacts();
    }

    @Transactional
    @Override
    public void removeContact(Integer id) {
        contactDAO.removeContact(id);
    }
}
