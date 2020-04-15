package dt.cms.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Conference")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pc_id")
    private ProgramCommitee committee;

    @Column(name = "phase", nullable = false)
    private String phase;

    @OneToMany(mappedBy = "conference", fetch = FetchType.EAGER)
    private List<Submission> submissions;

    @Override
    public String toString() {
        return "Conference{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", commitee=" + committee +
                ", phase='" + phase + '\'' +
                ", submissions=" + submissions +
                '}';
    }
}
