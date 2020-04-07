package domain;

public class Evaluation {
    private User reviewer;
    private String result;
    private String justification;

    public Evaluation(User reviewer, String result, String justification) {
        this.reviewer = reviewer;
        this.result = result;
        this.justification = justification;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    @Override
    public String toString() {
        return "Evaluation{" +
                "reviewer=" + reviewer +
                ", result='" + result + '\'' +
                ", justification='" + justification + '\'' +
                '}';
    }
}
