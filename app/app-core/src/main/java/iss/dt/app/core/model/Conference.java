package iss.dt.app.core.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "conference")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Conference implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private String phase;

    @OneToOne(fetch = FetchType.EAGER)
    private ProgramCommittee committee;

    @OneToMany(mappedBy = "conference", fetch = FetchType.EAGER)
    private List<Submission> submissions;

    @OneToOne
    private Event event;

    public Conference(Long id, String title, String description, String phase) {
        this.id=id;
        this.title=title;
        this.description=description;
        this.phase=phase;
    }
}
