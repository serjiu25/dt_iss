package iss.dt.app.core.repository;

import iss.dt.app.core.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EvaluationRepository extends JpaRepository<Evaluation, Integer> {
}
