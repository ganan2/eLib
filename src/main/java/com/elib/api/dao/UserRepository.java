package com.elib.api.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.elib.api.domain.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>{

}
