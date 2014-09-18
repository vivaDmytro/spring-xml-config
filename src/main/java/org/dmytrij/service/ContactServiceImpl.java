package org.dmytrij.service;

import org.dmytrij.dao.ContactDao;
import org.dmytrij.entity.Contact;

import java.util.List;

/**
 * Created by Дмитрий on 18.09.14.
 */
public class ContactServiceImpl implements ContactService {

    private ContactDao contactDao;
    private Integer macContactsCount;

    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public void setMacContactsCount(Integer macContactsCount) {
        this.macContactsCount = macContactsCount;
    }

    @Override
    public void addContact(Contact contact) {

        if(getAllContacts().size() >= macContactsCount) {
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
}
