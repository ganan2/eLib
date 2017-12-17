package com.elib.api.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.elib.api.domain.security.Role;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
    Role findByName(String name);
}