package iss.dt.app.web.controller;

import iss.dt.app.core.model.Section;
import iss.dt.app.core.service.SectionService;
import iss.dt.app.web.converter.SectionConverter;
import iss.dt.app.web.dto.SectionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SectionController {
    @Autowired
    private SectionService service;
    @Autowired
    private SectionConverter converter;
    //todo: login logout posts , updateSection fields
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/sections/c/{conferenceId}", method = RequestMethod.GET)
    public List<SectionDto> getSections(@PathVariable final Long conferenceId) {
        //log.trace("getSections");
        List<Section> sections = service.findByConference(conferenceId);
        //log.trace("getSections: sections={}", sections);
        return new ArrayList<>(converter.convertModelsToDtos(sections));
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/sections/{sectionId}", method = RequestMethod.GET)
    public SectionDto getSection(@PathVariable final Long sectionId) {
        //log.trace("getSection");
        Section section = service.findOne(sectionId);
        //log.trace("getSection: sections={}", section);
        return converter.convertModelToDto(section);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/sections/{sectionId}", method = RequestMethod.PUT)
    public SectionDto updateSection(
            @PathVariable final Long sectionId,
            @RequestBody final SectionDto sectionDto) {
        //log.trace("updateSection: sectionId={}, sectionDtoMap={}", sectionId, sectionDto);
        sectionDto.setId(sectionId);
        Section section = service.updateSection(converter.convertDtoToModel(sectionDto));
        //log.trace("updateSection: result={}", result);

        return converter.convertModelToDto(section);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/sections", method = RequestMethod.POST)
    SectionDto saveSection(@RequestBody SectionDto sectionDto) {
        return converter.convertModelToDto(
                service.saveSection(
                        converter.convertDtoToModel(sectionDto)
                )
        );
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/sections/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteSection(@PathVariable Long id) {
        service.deleteSection(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
