package iss.dt.app.web.controller;

import iss.dt.app.core.model.Submission;
import iss.dt.app.core.service.SubmissionService;
import iss.dt.app.web.converter.SubmissionConverter;
import iss.dt.app.web.dto.SubmissionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SubmissionController {
    @Autowired
    private SubmissionService service;
    @Autowired
    private SubmissionConverter converter;
    //todo:updateSubmission fields
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/submissions/c/{conferenceId}", method = RequestMethod.GET)
    public List<SubmissionDto> getSubmissions(@PathVariable final Long conferenceId) {
        //log.trace("getSubmissions");
        List<Submission> submissions = service.findByConference(conferenceId);
        //log.trace("getSubmissions: submissions={}", submissions);
        return new ArrayList<>(converter.convertModelsToDtos(submissions));
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/submissions/{submissionId}", method = RequestMethod.GET)
    public SubmissionDto getSubmission(@PathVariable final Long submissionId) {
        //log.trace("getSubmission");
        Submission submission = service.findOne(submissionId);
        //log.trace("getSubmission: submissions={}", submission);
        return new converter.convertModelToDto(submission);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/submissions/{submissionId}", method = RequestMethod.PUT)
    public SubmissionDto updateSubmission(
            @PathVariable final Long submissionId,
            @RequestBody final SubmissionDto submissionDto) {
        //log.trace("updateSubmission: submissionId={}, submissionDtoMap={}", submissionId, submissionDto);
        Submission submission = service.updateSubmission(submissionId,
                submissionDto.getSerialNumber(),
                submissionDto.getName(), submissionDto.getGroupNumber());
        SubmissionDto result = converter.convertModelToDto(submission);
        //log.trace("updateSubmission: result={}", result);

        return result;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/submissions", method = RequestMethod.POST)
    SubmissionDto saveSubmission(@RequestBody SubmissionDto submissionDto) {
        return converter.convertModelToDto(
                service.saveSubmission(
                        converter.convertDtoToModel(submissionDto)
                )
        );
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/submissions/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteSubmission(@PathVariable Long id) {
        service.deleteSubmission(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}