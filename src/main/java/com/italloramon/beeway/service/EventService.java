package com.italloramon.beeway.service;

import com.italloramon.beeway.dto.EventDtoRequest;
import com.italloramon.beeway.dto.EventDtoResponse;

public interface EventService {
    EventDtoResponse saveEvent(EventDtoRequest eventDtoRequest);

    EventDtoResponse updateEvent(EventDtoRequest eventDtoRequest, Long idOlderEvent);

    void deleteEventById(Long id);
}
