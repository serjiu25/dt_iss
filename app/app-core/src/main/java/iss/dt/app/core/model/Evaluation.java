package iss.dt.app.core.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="evaluation")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Evaluation {
    @Id
    @GeneratedValue
    private Long id;
    private String result;
    private String justification;

    @ManyToOne
    private Submission submission;

    @ManyToOne
    private User reviewer;

    public Evaluation (Long id, String result, String justification) {
        this.id = id;
        this.result = result;
        this.justification = justification;
    }

}
