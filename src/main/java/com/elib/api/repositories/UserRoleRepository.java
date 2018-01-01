package com.elib.api.repositories;

import com.elib.api.domain.security.UserRole;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRoleRepository extends PagingAndSortingRepository<UserRole, Long> {
}
