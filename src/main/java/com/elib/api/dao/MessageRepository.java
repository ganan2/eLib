package com.elib.api.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.elib.api.domain.Message;

public interface MessageRepository extends PagingAndSortingRepository<Message, Long>{

}
