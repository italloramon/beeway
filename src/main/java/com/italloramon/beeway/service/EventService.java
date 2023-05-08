package com.italloramon.beeway.service;

import com.italloramon.beeway.dto.EventDtoRequest;
import com.italloramon.beeway.dto.EventDtoResponse;
import com.italloramon.beeway.model.Event;

import java.util.List;

public interface EventService {
    EventDtoResponse saveEvent(EventDtoRequest eventDtoRequest);

    EventDtoResponse updateEvent(EventDtoRequest eventDtoRequest, Long idOlderEvent);

    void deleteEventById(Long id);

    List<Event> findAll();
}
