package com.elib.api.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.elib.api.domain.StoryNode;

public interface StoryNodeRepository extends PagingAndSortingRepository<StoryNode, Long>{

}
