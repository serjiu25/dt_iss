package dt.cms.domain;

import java.util.List;

public class Submission {
    private User author;
    private Paper paper;
    private List<Evaluation> evaluations;

    public Submission(User author, Paper paper, List<Evaluation> evaluations) {
        this.author = author;
        this.paper = paper;
        this.evaluations = evaluations;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    @Override
    public String toString() {
        return "Submission{" +
                "author=" + author +
                ", paper=" + paper +
                ", evaluations=" + evaluations +
                '}';
    }
}
