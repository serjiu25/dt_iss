package iss.dt.app.web.controller;

import iss.dt.app.core.model.Paper;
import iss.dt.app.core.service.PaperService;
import iss.dt.app.web.converter.PaperConverter;
import iss.dt.app.web.dto.PaperDto;
import iss.dt.app.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PaperController {
    @Autowired
    private PaperService service;
    @Autowired
    private PaperConverter converter;
    //todo:updatePaper fields
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/papers/c/{conferenceId}", method = RequestMethod.GET)
    public List<PaperDto> getPapers(@PathVariable final Long conferenceId) {
        //log.trace("getPapers");
        List<Paper> papers = service.findByConference(conferenceId);
        //log.trace("getPapers: papers={}", papers);
        return new ArrayList<>(converter.convertModelsToDtos(papers));
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/papers/{paperId}", method = RequestMethod.GET)
    public PaperDto getPaper(@PathVariable final Long paperId) {
        //log.trace("getPaper");
        Paper paper = service.findOne(paperId);
        //log.trace("getPaper: papers={}", paper);
        return converter.convertModelToDto(paper);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/papers/{paperId}", method = RequestMethod.PUT)
    public PaperDto updatePaper(
            @PathVariable final Long paperId,
            @RequestBody final PaperDto paperDto) {
        //log.trace("updatePaper: paperId={}, paperDtoMap={}", paperId, paperDto);
        paperDto.setId(paperId);
        Paper paper = service.updatePaper(converter.convertDtoToModel(paperDto));
        //log.trace("updatePaper: result={}", result);

        return converter.convertModelToDto(paper);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/papers", method = RequestMethod.POST)
    PaperDto savePaper(@RequestBody PaperDto paperDto) {
        return converter.convertModelToDto(
                service.savePaper(
                        converter.convertDtoToModel(paperDto)
                )
        );
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/papers/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deletePaper(@PathVariable Long id) {
        service.deletePaper(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
