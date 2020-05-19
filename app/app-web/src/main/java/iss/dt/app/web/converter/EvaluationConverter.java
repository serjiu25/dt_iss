package iss.dt.app.web.converter;

import iss.dt.app.core.model.Evaluation;
import iss.dt.app.web.dto.EvaluationDto;
import org.springframework.stereotype.Component;

@Component
public class EvaluationConverter extends BaseConverter<Evaluation, EvaluationDto> {

    @Override
    public Evaluation convertDtoToModel(EvaluationDto dto) {
        UserConverter cuc=new UserConverter();
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

        UserConverter cuc=new UserConverter();
        SubmissionConverter sc=new SubmissionConverter();
        EvaluationDto evaluationdto = new EvaluationDto(evaluation.getResult()
                                                    ,evaluation.getJustification()
                                                    ,sc.convertModelToDto(evaluation.getSubmission())
                                                    ,cuc.convertModelToDto(evaluation.getReviewer()));
        evaluationdto.setId(evaluation.getId());
        return evaluationdto;
    }
}
