package com.italloramon.beeway.repository;

import com.italloramon.beeway.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
