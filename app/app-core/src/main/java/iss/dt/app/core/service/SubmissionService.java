package iss.dt.app.core.service;
import iss.dt.app.core.model.Submission;
public interface SubmissionService {
    Submission findOne(Long id);

    List<Submission> findByConference(Long id);

    Submission updateSubmission(); //todo :getparams

    Submission saveSubmission(Submission submission);

    void deleteSubmission(Long id);
}
