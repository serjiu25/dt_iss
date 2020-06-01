package iss.dt.app.web.controller;

import iss.dt.app.core.model.Conference;
import iss.dt.app.core.service.ConferenceService;
import iss.dt.app.core.service.UserService;
import iss.dt.app.web.converter.ConferenceConverter;
import iss.dt.app.web.converter.UserConverter;
import iss.dt.app.web.dto.ConferenceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ConferenceController {
    @Autowired
    private ConferenceService service;
    @Autowired
    private ConferenceConverter converter;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private UserService userService;

    //todo: updateConference fields
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/conferences", method = RequestMethod.GET)
    public List<ConferenceDto> getConferences() {
        //log.trace("getConferences");
        List<Conference> conferences = service.findAll();
        //log.trace("getConferences: conferences={}", conferences);
        return new ArrayList<>(converter.convertModelsToDtos(conferences));
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/conferences/topic/{topic}", method = RequestMethod.GET)
    public List<ConferenceDto> getConferencesByTopic(@PathVariable final String topic) {
        //log.trace("getConferences");
        List<Conference> conferences = service.findByTopic(topic);
        //log.trace("getConferences: conferences={}", conferences);
        return new ArrayList<>(converter.convertModelsToDtos(conferences));
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/conferences/{conferenceId}", method = RequestMethod.GET)
    public ConferenceDto getConference(@PathVariable final Long conferenceId) {
        //log.trace("getConference");
        Conference conference = service.findOne(conferenceId);
        //log.trace("getConference: conferences={}", conference);
        return converter.convertModelToDto(conference);
    }

    @Transactional
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/conferences/author/{userId}", method = RequestMethod.GET)
    public List<ConferenceDto> getConferencesByAuthor(@PathVariable final Long userId) {
        //log.trace("getConference");

        List<Conference> conferences = service.findForAuthor(userId);
        //log.trace("getConference: conferences={}", conference);
        return new ArrayList<>(converter.convertModelsToDtos(conferences));
    }

    @Transactional
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/conferences/pc/{userId}", method = RequestMethod.GET)
    public List<ConferenceDto> getConferencesByPC(@PathVariable final Long userId) {
        //log.trace("getConference");
        List<Conference> conferences = service.findForPC(userId);
        //log.trace("getConference: conferences={}", conference);
        return new ArrayList<>(converter.convertModelsToDtos(conferences));
    }

    @RequestMapping(value = "/conferences/isAuthor/{confId}/{userId}", method = RequestMethod.GET)
    public boolean isAuthor(@PathVariable final Long confId,
                            @PathVariable final Long userId) {
        //log.trace("getConference");
        boolean response = service.isAuthor(confId,userId);
        //log.trace("getConference: conferences={}", conference);
        return response;
    }
    
    @RequestMapping(value = "/conferences/isPC/{confId}/{userId}", method = RequestMethod.GET)
    public boolean isPC(@PathVariable final Long confId,
                        @PathVariable final Long userId) {
        //log.trace("getConference");
        boolean response = service.isPC(confId,userId);
        //log.trace("getConference: conferences={}", conference);
        return response;
    }
    @RequestMapping(value = "/conferences/isReviewer/{confId}/{userId}", method = RequestMethod.GET)
    public boolean isReviewer(@PathVariable final Long confId,
                        @PathVariable final Long userId) {
        //log.trace("getConference");
        boolean response = service.isReviewer(confId,userId);
        //log.trace("getConference: conferences={}", conference);
        return response;
    }

    @RequestMapping(value = "/TEST/{confId}/{userId}", method = RequestMethod.GET)
    public boolean testTEST(@PathVariable final Long confId,
                            @PathVariable final Long userId) {
        return service.isReviewer(confId, userId) && service.isPC(confId, userId);
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/conferences/{conferenceId}", method = RequestMethod.PUT)
    public ConferenceDto updateConference(
            @PathVariable final Long conferenceId,
            @RequestBody final ConferenceDto conferenceDto) {
        //log.trace("updateConference: conferenceId={}, conferenceDtoMap={}", conferenceId, conferenceDto);
        conferenceDto.setId(conferenceId);
        Conference conference = service.updateConference(converter.convertDtoToModel(conferenceDto));
        //log.trace("updateConference: result={}", result);

        return converter.convertModelToDto(conference);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/conferences", method = RequestMethod.POST)
    public ConferenceDto saveConference(@RequestBody ConferenceDto conferenceDto) {
        return converter.convertModelToDto(
                service.saveConference(
                        converter.convertDtoToModel(conferenceDto)
                )
        );
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/conferences/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteConference(@PathVariable Long id) {
        service.deleteConference(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}