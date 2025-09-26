package com.tbc.point.domain.repository;

import com.tbc.point.domain.model.Meetup;

import java.util.Optional;

public interface MeetupRepository {
    Optional<Meetup> findById(Long meetupId); // String → Long
}
