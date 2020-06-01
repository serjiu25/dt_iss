package iss.dt.app.web.controller;

import iss.dt.app.core.model.Evaluation;
import iss.dt.app.core.service.EvaluationService;
import iss.dt.app.core.service.SubmissionService;
import iss.dt.app.web.converter.EvaluationConverter;
import iss.dt.app.web.converter.SubmissionConverter;
import iss.dt.app.web.dto.ConferenceDto;
import iss.dt.app.web.dto.EvaluationDto;
import iss.dt.app.web.dto.SubmissionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EvaluationController {
    @Autowired
    private EvaluationService service;
    @Autowired
    private EvaluationConverter converter;
    @Autowired
    private SubmissionConverter subConverter;
    //todo: updateEvaluation fields
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/evaluations/s/{submissionId}", method = RequestMethod.GET)
    public List<EvaluationDto> getEvaluations(@PathVariable final Long submissionId) {
        //log.trace("getEvaluations");
        List<Evaluation> evaluations = service.findBySubmission(submissionId);
        //log.trace("getEvaluations: evaluations={}", evaluations);
        return new ArrayList<>(converter.convertModelsToDtos(evaluations));
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/evaluations/{evaluationId}", method = RequestMethod.GET)
    public EvaluationDto getEvaluation(@PathVariable final Long evaluationId) {
        //log.trace("getEvaluation");
        Evaluation evaluation = service.findOne(evaluationId);
        //log.trace("getEvaluation: evaluations={}", evaluation);
        return converter.convertModelToDto(evaluation);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/evaluations/reviewer/{conferenceId}/{userId}", method = RequestMethod.GET)
    public List<EvaluationDto> getReviewerEvalulations(@PathVariable final Long conferenceId,
                                              @PathVariable final Long userId) {
        return new ArrayList<>(converter.convertModelsToDtos(service.findForReviewer(conferenceId,userId)));
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/evaluations/reviewer/s/{conferenceId}/{userId}", method = RequestMethod.GET)
    public List<SubmissionDto> getReviewerSubmissions(@PathVariable final Long conferenceId,
                                                      @PathVariable final Long userId) {
        return service.findForReviewer(conferenceId,userId).stream().
                map(eval->subConverter.convertModelToDto(eval.getSubmission()))
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/evaluations/{evaluationId}", method = RequestMethod.PUT)
    public EvaluationDto updateEvaluation(
            @PathVariable final Long evaluationId,
            @RequestBody final EvaluationDto evaluationDto) {
        //log.trace("updateEvaluation: evaluationId={}, evaluationDtoMap={}", evaluationId, evaluationDto);
        evaluationDto.setId(evaluationId);
        Evaluation evaluation = service.updateEvaluation(
                converter.convertDtoToModel(evaluationDto)
        );
        //log.trace("updateEvaluation: result={}", result);

        return converter.convertModelToDto(evaluation);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/evaluations", method = RequestMethod.POST)
    EvaluationDto saveEvaluation(@RequestBody EvaluationDto evaluationDto) {
        return converter.convertModelToDto(
                service.saveEvaluation(
                        converter.convertDtoToModel(evaluationDto)
                )
        );
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/evaluations/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteEvaluation(@PathVariable Long id) {
        service.deleteEvaluation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
