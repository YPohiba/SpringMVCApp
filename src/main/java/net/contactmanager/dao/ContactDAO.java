package net.contactmanager.dao;

import net.contactmanager.domain.Contact;

import java.util.List;

public interface ContactDAO {

    public void addContact(Contact contact);

    public List<Contact> listContacts();

    public void removeContact(Integer id);

}
