package com.elib.api.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.elib.api.domain.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>{

	User findByEmail(String email);

	User findByUsername(String userName);

}
