package iss.dt.app.core.service;
import iss.dt.app.core.model.Submission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
public class SubmissionServiceImpl implements SubmissionService{
    @Autowired
    private SubmissionRepo repo;
    @Override
    public List<Submission> findByConference(Long id){
        return repo.findAll().stream().filter(sub->sub.getConference().equals(id)).collect(Collectors.toList());
    }
    @Override
    public Submission findOne(Long id){
        return repo.findAll().stream().filter(submission->submission.getId().equals(id)).findAny().orElse(null);
    }
    @Override
    @Transactional
    public Submission updateSubmission() {
        Optional<Submission> submission = repo.findById(submissionID);
        submission.ifPresent(s -> {
            //update
        });
        return submission.orElse(null);
    }
    @Override
    public Submission saveSubmission(Submission submission){
        return repo.save(submission);
    }
    @Override
    public void deleteSubmission(Long id){
        repo.deleteById(id);
    }
}
