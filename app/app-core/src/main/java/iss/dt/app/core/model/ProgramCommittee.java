package iss.dt.app.core.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "programcommittee")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProgramCommittee {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User chair;

    @ManyToMany( fetch = FetchType.EAGER)
    private List<User> co_chairs;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> reviewers;

    @OneToOne(mappedBy = "committee")
    private Conference conference;

    public ProgramCommittee (Long id, User chair, List<User> co_chairs) {
        this.id = id;
        this.chair = chair;
        this.co_chairs = co_chairs;
    }

}
