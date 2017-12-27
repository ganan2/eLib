package com.elib.api.repositories;

import com.elib.api.domain.Search;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SearchRepository extends PagingAndSortingRepository<Search, Long> {
}
