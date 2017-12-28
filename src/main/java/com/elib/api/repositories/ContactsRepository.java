package com.elib.api.repositories;

import com.elib.api.domain.Contacts;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContactsRepository extends PagingAndSortingRepository<Contacts, Long>{
}