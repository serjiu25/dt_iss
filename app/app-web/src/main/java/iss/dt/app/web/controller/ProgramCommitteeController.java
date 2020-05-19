package iss.dt.app.web.controller;

import iss.dt.app.core.model.ProgramCommittee;
import iss.dt.app.core.model.User;
import iss.dt.app.core.service.ProgramCommitteeService;
import iss.dt.app.web.converter.ProgramCommitteeConverter;
import iss.dt.app.web.converter.UserConverter;
import iss.dt.app.web.dto.ProgramCommitteeDto;
import iss.dt.app.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProgramCommitteeController {
    @Autowired
    private ProgramCommitteeService service;
    @Autowired
    private ProgramCommitteeConverter converter;
    @Autowired
    private ProgramCommitteeConverter userConverter;

    //todo:updateProgramCommittee fields,addPCMember implementation
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/pc/c/{conferenceId}", method = RequestMethod.GET)
    public ProgramCommitteeDto getProgramCommitteeForConference(@PathVariable final Long conferenceId) {
        //log.trace("getProgramCommittees");
        ProgramCommittee programCommittee = service.findByConference(conferenceId);
        //log.trace("getProgramCommittees: programCommittees={}", programCommittees);
        return converter.convertModelToDto(programCommittee);
    }
    /*
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/pc/accept/{programCommitteeId}", method = RequestMethod.PUT)
    public ProgramCommitteeDto addPCMember(@PathVariable final Long conferenceId,@RequestBody UserDto userDto) {
        //log.trace("getProgramCommittees");
        // response type? ProgramCommittee programCommittees = service.addMember(userConverter.convertDtoToModel(userDto));
        //log.trace("getProgramCommittees: programCommittees={}", programCommittees);
        //return type? return new converter.convertModelToDto(programCommittees);
    }*/

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/pc/{programCommitteeId}", method = RequestMethod.GET)
    public ProgramCommitteeDto getProgramCommittee(@PathVariable final Long programCommitteeId) {
        //log.trace("getProgramCommittee");
        ProgramCommittee programCommittee = service.findOne(programCommitteeId);
        //log.trace("getProgramCommittee: programCommittees={}", programCommittee);
        return converter.convertModelToDto(programCommittee);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/pc/{programCommitteeId}", method = RequestMethod.PUT)
    public ProgramCommitteeDto updateProgramCommittee(
            @PathVariable final Long programCommitteeId,
            @RequestBody final ProgramCommitteeDto programCommitteeDto) {
        //log.trace("updateProgramCommittee: programCommitteeId={}, programCommitteeDtoMap={}", programCommitteeId, programCommitteeDto);
        programCommitteeDto.setId(programCommitteeId);
        ProgramCommittee programCommittee = service.updateProgramCommittee(
                converter.convertDtoToModel(programCommitteeDto)
        );
        //log.trace("updateProgramCommittee: result={}", result);

        return converter.convertModelToDto(programCommittee);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/pc", method = RequestMethod.POST)
    ProgramCommitteeDto saveProgramCommittee(@RequestBody ProgramCommitteeDto programCommitteeDto) {
        return converter.convertModelToDto(
                service.saveProgramCommittee(
                        converter.convertDtoToModel(programCommitteeDto)
                )
        );
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/pc/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteProgramCommittee(@PathVariable Long id) {
        service.deleteProgramCommittee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}