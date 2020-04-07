package domain;

import java.util.List;

public class Conference {
    private String title;
    private String description;
    private ProgramCommitee commitee;
    private String phase;
    private List<Submission> submissions;

    public Conference(String title, String description, ProgramCommitee commitee, String phase, List<Submission> submissions) {
        this.title = title;
        this.description = description;
        this.commitee = commitee;
        this.phase = phase;
        this.submissions = submissions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProgramCommitee getCommitee() {
        return commitee;
    }

    public void setCommitee(ProgramCommitee commitee) {
        this.commitee = commitee;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public List<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(List<Submission> submissions) {
        this.submissions = submissions;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", commitee=" + commitee +
                ", phase='" + phase + '\'' +
                ", submissions=" + submissions +
                '}';
    }
}
