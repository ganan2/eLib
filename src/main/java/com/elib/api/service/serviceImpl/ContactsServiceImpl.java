package com.elib.api.service.serviceImpl;

import com.elib.api.domain.Contacts;
import com.elib.api.domain.User;
import com.elib.api.repositories.ContactsRepository;
import com.elib.api.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactsServiceImpl implements ContactsService {

    @Autowired
    private ContactsRepository contactsRepository;

    @Override
    public boolean createUserContactsList(User user, String username){
        Contacts contacts = new Contacts();
        contacts.setUser(user);
        contacts.setContactUsername(username);
        user.getContacts().add(contacts);
        contactsRepository.save(contacts);

        return true;
    }
}
