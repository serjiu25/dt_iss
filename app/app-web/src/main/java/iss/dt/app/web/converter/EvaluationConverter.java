package iss.dt.app.web.converter;

import iss.dt.app.core.model.Evaluation;
import iss.dt.app.web.dto.EvaluationDto;
import org.springframework.stereotype.Component;

@Component
public class EvaluationConverter extends BaseConverter<Evaluation, EvaluationDto> {

    @Override
    public Evaluation convertDtoToModel(EvaluationDto dto) {
        return new Evaluation(dto.getId(),
                                dto.getResult(),
                                dto.getJustification());
    }

    @Override
    public EvaluationDto convertModelToDto(Evaluation evaluation) {

        UserConverter cuc=new UserConverter();
        EvaluationDto evaluationdto = new EvaluationDto(
                evaluation.getResult(),
                evaluation.getJustification(),
                evaluation.getSubmission().getId(),
                cuc.convertModelToDto(evaluation.getReviewer())
        );
        evaluationdto.setId(evaluation.getId());
        return evaluationdto;
    }
}
