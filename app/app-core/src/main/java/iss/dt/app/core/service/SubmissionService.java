package iss.dt.app.core.service;
import iss.dt.app.core.model.Submission;

import java.util.List;

public interface SubmissionService {
    Submission findOne(Long id);

    List<Submission> findByConference(Long id);

    Submission updateSubmission(Submission submission); //todo :getparams

    Submission saveSubmission(Submission submission);

    void deleteSubmission(Long id);
}
