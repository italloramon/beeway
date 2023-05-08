package com.italloramon.beeway.service;

import com.italloramon.beeway.dto.EventDtoRequest;
import com.italloramon.beeway.dto.EventDtoResponse;
import com.italloramon.beeway.model.Event;
import com.italloramon.beeway.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EventServiceImpl implements EventService{

    private final EventRepository eventRepository;

    private final ModelMapper modelMapper;
    @Override
    public EventDtoResponse saveEvent(EventDtoRequest eventDtoRequest) {
        Event event = modelMapper.map(eventDtoRequest, Event.class);

        EventDtoResponse eventDtoResponse = modelMapper.map(eventRepository.save(event), EventDtoResponse.class);

        return eventDtoResponse;
    }

    @Override
    public EventDtoResponse updateEvent(EventDtoRequest eventDtoRequest, Long idOlderEvent) {
        Event olderEvent = eventRepository.findById(idOlderEvent).get();
        olderEvent.setTitle(eventDtoRequest.getTitle());
        olderEvent.setDescription(eventDtoRequest.getDescription());
        olderEvent.setMaximumVouchers(eventDtoRequest.getMaximumVouchers());
        olderEvent.setCurrentVouchers(eventDtoRequest.getCurrentVouchers());
        olderEvent.setCreatedBy(eventDtoRequest.getCreatedBy());

        eventRepository.save(olderEvent);

        return modelMapper.map(olderEvent, EventDtoResponse.class);
    }

    @Override
    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }
}
