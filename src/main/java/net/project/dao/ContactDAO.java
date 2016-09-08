package net.project.dao;

import net.project.domain.Contact;

import java.util.List;

public interface ContactDAO {

    public void addContact(Contact contact);

    public List<Contact> listContacts();

    public void removeContact(Integer id);

}
