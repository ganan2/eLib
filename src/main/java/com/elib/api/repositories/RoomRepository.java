package com.elib.api.repositories;

import com.elib.api.domain.Room;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoomRepository extends PagingAndSortingRepository<Room, Long> {
}
