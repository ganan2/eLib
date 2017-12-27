package com.elib.api.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.elib.api.domain.User;

import java.util.Set;

public interface UserRepository extends PagingAndSortingRepository<User, Long>{

	User findByEmail(String email);

	User findByUsername(String username);

	Set<User>  findAllByUsername(String keyword);

	Set<User>  findAllByEmail(String keyword);

	Set<User> findAll();

}
