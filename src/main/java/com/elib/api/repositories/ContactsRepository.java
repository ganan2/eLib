package com.elib.api.repositories;

import com.elib.api.domain.Contacts;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;
import java.util.Set;

public interface ContactsRepository extends PagingAndSortingRepository<Contacts, Long>{
}