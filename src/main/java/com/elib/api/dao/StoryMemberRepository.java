package com.elib.api.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.elib.api.domain.StoryMember;

public interface StoryMemberRepository extends PagingAndSortingRepository<StoryMember, Long>{

}
