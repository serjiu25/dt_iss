package dt.cms.domain;

import java.util.List;

public class ProgramCommitee {
    private User chair;
    private List<User> co_chairs;
    private List<User> reviewers;

    public ProgramCommitee(User chair, List<User> co_chairs, List<User> reviewers) {
        this.chair = chair;
        this.co_chairs = co_chairs;
        this.reviewers = reviewers;
    }

    public User getChair() {
        return chair;
    }

    public void setChair(User chair) {
        this.chair = chair;
    }

    public List<User> getCo_chairs() {
        return co_chairs;
    }

    public void setCo_chairs(List<User> co_chairs) {
        this.co_chairs = co_chairs;
    }

    public List<User> getReviewers() {
        return reviewers;
    }

    public void setReviewers(List<User> reviewers) {
        this.reviewers = reviewers;
    }

    @Override
    public String toString() {
        return "ProgramCommitee{" +
                "chair=" + chair + '\n' +
                ", co_chairs=" + co_chairs + '\n' +
                ", reviewers=" + reviewers +
                '}';
    }
}
