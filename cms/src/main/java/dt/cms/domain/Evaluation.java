package dt.cms.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="Evaluation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "result", nullable = false)
    private String result;
    @Column(name = "justification", nullable = false)
    private String justification;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subm_id")
    private Submission submission;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User reviewer;

    @Override
    public String toString() {
        return "Evaluation{" +
                "reviewer=" + reviewer +
                ", result='" + result + '\'' +
                ", justification='" + justification + '\'' +
                '}';
    }
}
