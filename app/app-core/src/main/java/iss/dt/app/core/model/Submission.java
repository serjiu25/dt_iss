package iss.dt.app.core.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "submission")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User author;

    @OneToOne
    private Paper paper;

    @ManyToOne
    private Conference conference;

    @OneToMany(mappedBy = "submission")
    private List<Evaluation> evaluations;

    @OneToMany(mappedBy = "submission")
    private List<Bid> biddings;

    public Submission(Long id, User convertDtoToModel, Paper convertDtoToModel1) {
        this.id=id;
        this.author=convertDtoToModel;
        this.paper=convertDtoToModel1;
    }

    public void addBid(Bid bid) {
        this.biddings.add(bid);
    }
}
