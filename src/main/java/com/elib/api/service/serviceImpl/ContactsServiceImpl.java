package com.elib.api.service.serviceImpl;

import com.elib.api.repositories.ContactsRepository;
import com.elib.api.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactsServiceImpl implements ContactsService {

    @Autowired
    private ContactsRepository contactsRepository;

}
