package com.library.Book.Library.controller;

import com.library.Book.Library.entity.Event;
import com.library.Book.Library.exception.ResourceNotFoundException;
import com.library.Book.Library.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class EventController {

    private final EventService eventService;

    @GetMapping("/")
    public ResponseEntity<List<Event>> gelAllEvents() {
        return ResponseEntity.ok(eventService.findAll());
    }

    @PostMapping("/add")
    public Event addEvent(@RequestBody Event event) {
        return eventService.addEvent(event);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> findEventById(@PathVariable Long id) {
        Event event = eventService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event with id " + id + " was not found"));
        return ResponseEntity.ok(event);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Event>> findEventByName(@PathVariable String name) {
        List<Event> eventList = eventService.findByName(name);
        if (!eventList.isEmpty()) {
            return ResponseEntity.ok(eventList);
        } else {
            throw new ResourceNotFoundException("No event found");
        }
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Event>> findEventByDate(@PathVariable Date date) {
        List<Event> eventList = eventService.findByDate(date);
        if (!eventList.isEmpty()) {
            return ResponseEntity.ok(eventList);
        } else {
            throw new ResourceNotFoundException("No event found");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event updatedEvent) {
        eventService.update(id, updatedEvent);
        return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAuthor(@PathVariable Long id) {
        Event event = eventService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event with id " + id + " was not found"));
        eventService.delete(event);
        Map<String, Boolean> response = new HashMap<>();
        return ResponseEntity.ok(response);
    }
}