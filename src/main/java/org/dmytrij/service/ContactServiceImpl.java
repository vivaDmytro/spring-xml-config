package org.dmytrij.service;

import org.dmytrij.dao.ContactDao;
import org.dmytrij.entity.Contact;

import java.util.List;

/**
 * Created by Дмитрий on 18.09.14.
 */
public class ContactServiceImpl implements ContactService {

    private ContactDao contactDao;
    private Integer maxContactsCount;

    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public void setMaxContactsCount(Integer maxContactsCount) {
        this.maxContactsCount = maxContactsCount;
    }

    @Override
    public void addContact(Contact contact) {

        if(getAllContacts().size() >= maxContactsCount) {
            throw new RuntimeException("exceeds the maximum size of the list");
        }
        contactDao.addContact(contact);
    }

    @Override
    public void deleteContact(Contact contact) {

        contactDao.deleteContact(contact);
    }

    @Override
    public List<Contact> getAllContacts() {

        return contactDao.getAllContacts();
    }

    @Override
    public void clearAll() {
        contactDao.clearAll();
    }
}
