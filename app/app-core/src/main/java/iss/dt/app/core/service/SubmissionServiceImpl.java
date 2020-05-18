package iss.dt.app.core.service;
import iss.dt.app.core.model.Submission;
import iss.dt.app.core.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubmissionServiceImpl implements SubmissionService {
    @Autowired
    private SubmissionRepository repo;
    @Override
    public List<Submission> findByConference(Long id){
        return repo.findAll().stream().filter(sub->sub.getConference().getId() == id).collect(Collectors.toList());
    }
    @Override
    public Submission findOne(Long id){
        return repo.findAll().stream().filter(submission->submission.getId() == id).findAny().orElse(null);
    }
    @Override
    @Transactional
    public Submission updateSubmission(Submission submission) {
        return repo.save(submission);
    }
    @Override
    public Submission saveSubmission(Submission submission){
        return repo.save(submission);
    }
    @Override
    public void deleteSubmission(Long id){
        repo.deleteById(Math.toIntExact(id));
    }
}
