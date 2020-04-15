package dt.cms.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "Submission")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "paper_id")
    private Paper paper;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "conference_id")
    private Conference conference;

    @OneToMany
    private List<Evaluation> evaluations;


    @Override
    public String toString() {
        return "Submission{" +
                "author=" + author +
                ", paper=" + paper +
                ", evaluations=" + evaluations +
                '}';
    }
}
