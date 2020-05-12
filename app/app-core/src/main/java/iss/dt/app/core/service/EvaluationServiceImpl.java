package iss.dt.app.core.service;
import iss.dt.app.core.model.Evaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
public class EvaluationServiceImpl implements EvaluationService{
    @Autowired
    private EvaluationRepo repo;
    @Override
    public List<Evaluation> findAll(){
        return repo.findAll();
    }
    @Override
    public List<Evaluation> findBySubmission(Long id){
        return repo.findAll().stream().filter(eval->eval.getSubmission().equals(id)).collect(Collectors.toList());
    }
    @Override
    public Evaluation findOne(Long id){
        return repo.findAll().stream().filter(evaluation->evaluation.getId().equals(id)).findAny().orElse(null);
    }
    @Override
    @Transactional
    public Evaluation updateEvaluation() {
        Optional<Evaluation> evaluation = repo.findById(evaluationID);
        evaluation.ifPresent(u -> {
            //update
        });
        return evaluation.orElse(null);
    }
    @Override
    public Evaluation saveEvaluation(Evaluation evaluation){
        return repo.save(evaluation);
    }
    @Override
    public void deleteEvaluation(Long id){
        repo.deleteById(id);
    }
}
