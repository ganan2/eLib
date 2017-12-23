package com.elib.api.service;

import java.util.Set;

import com.elib.api.domain.User;
import com.elib.api.domain.security.UserRole;

public interface UserService {

	User findByUsername(String username);

	User findByEmail(String email);

	boolean checkUserExists(String userName, String email);

	boolean checkUsernameExists(String userName);

	boolean checkEmailExists(String email);

	void save (User user);

	boolean createUser(User user, Set<UserRole> userRoles);
}