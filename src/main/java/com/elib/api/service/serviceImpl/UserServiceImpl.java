package com.elib.api.service.serviceImpl;

import java.util.Set;

import javax.transaction.Transactional;

import com.elib.api.domain.Contacts;
import com.elib.api.repositories.ContactsRepository;
import com.elib.api.repositories.UserRoleRepository;
import com.elib.api.service.ContactsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.elib.api.domain.User;
import com.elib.api.domain.security.UserRole;
import com.elib.api.repositories.RoleRepository;
import com.elib.api.repositories.UserRepository;
import com.elib.api.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ContactsService contactsService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRoleRepository userRoleRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public User userRepository(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean createUser(User user, Set<UserRole> userRoles) {

        boolean isUserCreated = false;

        User localUser = userRepository.findByUsername(user.getUsername());

        if (localUser != null) {
            LOG.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
        } else {
            String encryptedPassword = passwordEncoder.encode(user.getPassword());
            String encryptedConfirmPassword = passwordEncoder.encode(user.getConfirmPassword());
            user.setPassword(encryptedPassword);
            user.setConfirmPassword(encryptedConfirmPassword);

            for (UserRole ur : userRoles) {
                userRoleRepository.save(ur);
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);

            contactsService.createUserContactsList(user, user.getUsername());

            localUser = userRepository.save(user);
        }

        return true;
    }

    public boolean checkUserExists(String username, String email){
        if (checkUsernameExists(username) || checkEmailExists(email)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkUsernameExists(String username) {
        if (null != findByUsername(username)) {
            return true;
        }

        return false;
    }

    public boolean checkEmailExists(String email) {
        if (null != findByEmail(email)) {
            return true;
        }

        return false;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByUsername(email);
    }
}