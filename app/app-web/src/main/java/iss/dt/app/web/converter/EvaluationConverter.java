package iss.dt.app.web.converter;

import iss.dt.app.core.model.Evaluation;
import iss.dt.app.web.dto.BaseDto;
import iss.dt.app.web.dto.EvaluationDto;

public class EvaluationConverter implements Converter<Evaluation, EvaluationDto> {
    /*
    Evauation
    private int id;
    private String result;
    private String justification;

    @ManyToOne(cascade = CascadeType.ALL)
    private Submission submission;

    @ManyToOne(cascade = CascadeType.ALL)
    private User reviewer;

    EVDTO
    private String result;
    private String justification;


    private SubmissionDto submission;
    private CuserDto reviewer;
     */
    @Override
    public Evaluation convertDtoToModel(EvaluationDto dto) {
        CuserConverter cuc=new CuserConverter();
        SubmissionConverter sc=new SubmissionConverter();
        Evaluation evaluation = new Evaluation(dto.getId()
                                              ,dto.getResult()
                                              ,dto.getJustification()
                                              ,sc.convertDtoToModel(dto.getSubmission())
                                              ,cuc.convertDtoToModel(dto.getReviewer()));
        return evaluation;
    }

    @Override
    public EvaluationDto convertModelToDto(Evaluation evaluation) {

        CuserConverter cuc=new CuserConverter();
        SubmissionConverter sc=new SubmissionConverter();
        EvaluationDto evaluationdto = new EvaluationDto(evaluation.getResult()
                                                    ,evaluation.getJustification()
                                                    ,sc.convertModelToDto(evaluation.getSubmission())
                                                    ,cuc.convertModelToDto(evaluation.getReviewer()));
        evaluationdto.setId(evaluation.getId());
        return evaluationdto;
    }
}
