package iss.dt.app.core.service;
import iss.dt.app.core.model.Evaluation;

import java.util.List;

public interface EvaluationService {
    List<Evaluation> findAll();
    List<Evaluation>  findForReviewer(Long confId,Long reviewerId);
    List<Evaluation> findBySubmission(Long id);

    Evaluation findOne(Long id);

    Evaluation updateEvaluation(Evaluation evaluation); //todo :getparams

    Evaluation saveEvaluation(Evaluation evaluation);

    void deleteEvaluation(Long id);
}