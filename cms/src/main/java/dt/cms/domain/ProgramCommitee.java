package dt.cms.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ProgramCommittee")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProgramCommitee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "chair_id")
    private User chair;
/*
    @ManyToMany(mappedBy = "Program Comitee", fetch = FetchType.EAGER)
    private List<User> co_chairs;
    @OneToMany(mappedBy = "Program Comitee", fetch = FetchType.EAGER)
    private List<User> reviewers;
 */

    @ManyToMany
    @JoinTable(
        name="FK_USER",
        joinColumns={@JoinColumn(name="PC_ID")},
        inverseJoinColumns={@JoinColumn(name="USER_ID")})
    private List<User> co_chairs;

    @Override
    public String toString() {
        return "ProgramCommitee{" +
                "chair=" + chair + '\n' +
                //", co_chairs=" + co_chairs + '\n' +
                //", reviewers=" + reviewers +
                '}';
    }
}
