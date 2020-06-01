package iss.dt.app.core.service;
import iss.dt.app.core.model.Evaluation;
import iss.dt.app.core.repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EvaluationServiceImpl implements EvaluationService{
    @Autowired
    private EvaluationRepository repo;
    @Override
    public List<Evaluation> findAll(){
        return repo.findAll();
    }

    @Override
    public List<Evaluation> findForReviewer(Long confId, Long reviewerId) {
        return repo.findAll().stream().filter(eval->{
            return eval.getReviewer().getId().equals(reviewerId) && eval.getSubmission().getConference().getId().equals(confId);
        }).collect(Collectors.toList());
    }
    @Override
    public List<Evaluation> findBySubmission(Long id){
        return repo.findAll().stream().filter(eval->eval.getSubmission().getId() == id).collect(Collectors.toList());
    }
    @Override
    public Evaluation findOne(Long id){
        return repo.findAll().stream().filter(evaluation->evaluation.getId() == id).findAny().orElse(null);
    }
    @Override
    @Transactional
    public Evaluation updateEvaluation(Evaluation evaluation) {
        return repo.save(evaluation);
    }
    @Override
    public Evaluation saveEvaluation(Evaluation evaluation){
        return repo.save(evaluation);
    }
    @Override
    public void deleteEvaluation(Long id){
        repo.deleteById(Math.toIntExact(id));
    }
}
