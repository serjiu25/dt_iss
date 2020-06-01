package iss.dt.app.web.controller;

import iss.dt.app.core.model.*;
import iss.dt.app.core.service.*;
import iss.dt.app.web.converter.SubmissionConverter;
import iss.dt.app.web.dto.SubmissionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SubmissionController {

    @Autowired private SubmissionService service;
    @Autowired private ConferenceService conferenceService;
    @Autowired private UserService userService;
    @Autowired private BidService bidService;
    @Autowired private EvaluationService evaluationService;

    @Autowired private SubmissionConverter converter;


    //todo:updateSubmission fields

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/submissions/bid/{submissionId}/{reviewerId}/{rate}", method = RequestMethod.GET)
    public void bidSubmission(
            @PathVariable final Long submissionId,
            @PathVariable final Long reviewerId,
            @PathVariable final Integer rate
    ) {
        Submission submission = service.findOne(submissionId);
        User user = userService.findOne(reviewerId);
        Bid bid = new Bid(null, user, submission, rate);
        bidService.save(bid);
    }

    @Transactional
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/submissions/assign/{conferenceId}", method = RequestMethod.GET)
    public void assignSubmissions(@PathVariable final Long conferenceId) {
        Conference conference = conferenceService.findOne(conferenceId);
        List<Submission> submissions = conference.getSubmissions();

        submissions.forEach(submission -> {
            List<User> reviewers = submission.getBiddings().stream()
                    .filter(bid -> bid.getRate() == 1)
                    .map(Bid::getReviewer)
                    .limit(3)
                    .collect(Collectors.toList());

            int moreReviewers = 3 - reviewers.size();
            submission.getBiddings().stream()
                    .filter(bid -> bid.getRate() == 0)
                    .map(Bid::getReviewer)
                    .limit(moreReviewers)
                    .forEach(reviewers::add);

            reviewers.forEach(reviewer -> {
                Evaluation evaluation = Evaluation.builder()
                        .reviewer(reviewer)
                        .submission(submission)
                        .build();
                evaluationService.saveEvaluation(evaluation);
            });
        });
    }

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
        return converter.convertModelToDto(submission);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/submissions/{submissionId}", method = RequestMethod.PUT)
    public SubmissionDto updateSubmission(
            @PathVariable final Long submissionId,
            @RequestBody final SubmissionDto submissionDto) {
        //log.trace("updateSubmission: submissionId={}, submissionDtoMap={}", submissionId, submissionDto);
        submissionDto.setId(submissionId);
        Submission submission = service.updateSubmission(converter.convertDtoToModel(submissionDto));
        //log.trace("updateSubmission: result={}", result);

        return converter.convertModelToDto(submission);
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