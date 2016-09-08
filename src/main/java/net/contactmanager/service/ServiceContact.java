package net.contactmanager.service;

import net.contactmanager.domain.Contact;

import java.util.List;

public interface ServiceContact {

    public void addContact(Contact contact);

    public List<Contact> listContacts();

    public void removeContact(Integer id);

}
