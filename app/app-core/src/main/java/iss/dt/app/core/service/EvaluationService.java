package iss.dt.app.core.service;
import iss.dt.app.core.model.Evaluation;
public interface EvaluationService {
    List<Evaluation> findAll();

    List<Evaluation> findBySubmission(Long id);

    Evaluation findOne(Long id);

    Evaluation updateEvaluation(); //todo :getparams

    Evaluation saveEvaluation(Evaluation evaluation);

    void deleteEvaluation(Long id);
}