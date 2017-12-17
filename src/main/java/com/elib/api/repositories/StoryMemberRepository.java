package com.elib.api.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.elib.api.domain.StoryMember;

public interface StoryMemberRepository extends PagingAndSortingRepository<StoryMember, Long>{

}
