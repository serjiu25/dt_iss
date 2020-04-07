package dt.cms.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Program Comitee")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProgramCommitee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pc_id;

    @Column(name = "chair", nullable = false)
    private User chair;

    @OneToMany(mappedBy = "CUser", fetch = FetchType.EAGER)
    private List<User> co_chairs = new ArrayList<>();
    @OneToMany(mappedBy = "CUser", fetch = FetchType.EAGER)
    private List<User> reviewers = new ArrayList<>();

    @Override
    public String toString() {
        return "ProgramCommitee{" +
                "chair=" + chair + '\n' +
                ", co_chairs=" + co_chairs + '\n' +
                ", reviewers=" + reviewers +
                '}';
    }
}
