package com.library.Book.Library.service;

import com.library.Book.Library.entity.Author;
import com.library.Book.Library.entity.Event;
import com.library.Book.Library.exception.ResourceNotFoundException;
import com.library.Book.Library.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public Event addEvent(Event event){
        return eventRepository.save(event);
    }

    public List<Event> findAll(){return eventRepository.findAllByOrderByDateDesc();}

    public Optional<Event> findById(Long id){
        return eventRepository.findById(id);
    }

    public List<Event> findByName(String name){
        return eventRepository.findAllByNameContainingOrderByDateDesc(name);
    }

    public List<Event> findByDate(Date date){
        return eventRepository.findByDate(date);
    }

    public void update(Long id, Event updatedEvent){
            Event oldEvent = eventRepository.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("Event not found"));
            oldEvent.setName(updatedEvent.getName());
            oldEvent.setDate(updatedEvent.getDate());
            oldEvent.setDetails(updatedEvent.getDetails());
    }

    public void delete(Event event){
        eventRepository.delete(event);
    }


}
