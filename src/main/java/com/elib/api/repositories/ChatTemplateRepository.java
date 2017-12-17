package com.elib.api.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.elib.api.domain.ChatTemplate;

public interface ChatTemplateRepository extends PagingAndSortingRepository<ChatTemplate, Long>{

}
