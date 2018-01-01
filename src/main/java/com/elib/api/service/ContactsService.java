package com.elib.api.service;

import com.elib.api.domain.User;

public interface ContactsService {

    boolean createUserContactsList(User user, String username);

}
