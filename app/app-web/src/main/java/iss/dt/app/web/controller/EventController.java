package iss.dt.app.web.controller;

import iss.dt.app.core.model.Event;
import iss.dt.app.core.service.EventService;
import iss.dt.app.web.converter.EventConverter;
import iss.dt.app.web.dto.EventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EventController {
    @Autowired
    private EventService service;
    @Autowired
    private EventConverter converter;
    //todo: updateEvent fields
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/events/c/{conferenceId}", method = RequestMethod.GET)
    public EventDto getEventForConference(@PathVariable final Long conferenceId) {
        //log.trace("getEvents");
        Event event = service.findByConference(conferenceId);
        //log.trace("getEvents: events={}", events);
        return new converter.convertModelToDto(event);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/events/{eventId}", method = RequestMethod.GET)
    public EventDto getEvent(@PathVariable final Long eventId) {
        //log.trace("getEvent");
        Event event = service.findOne(eventId);
        //log.trace("getEvent: events={}", event);
        return new converter.convertModelToDto(event);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/events/{eventId}", method = RequestMethod.PUT)
    public EventDto updateEvent(
            @PathVariable final Long eventId,
            @RequestBody final EventDto eventDto) {
        //log.trace("updateEvent: eventId={}, eventDtoMap={}", eventId, eventDto);
        Event event = service.updateEvent(eventId,
                eventDto.getSerialNumber(),
                eventDto.getName(), eventDto.getGroupNumber());
        EventDto result = converter.convertModelToDto(event);
        //log.trace("updateEvent: result={}", result);

        return result;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/events", method = RequestMethod.POST)
    EventDto saveEvent(@RequestBody EventDto eventDto) {
        return converter.convertModelToDto(
                service.saveEvent(
                        converter.convertDtoToModel(eventDto)
                )
        );
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/events/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteEvent(@PathVariable Long id) {
        service.deleteEvent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}