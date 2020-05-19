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

    @OneToOne(cascade = CascadeType.ALL)
    private ProgramCommittee committee;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conference")
    private List<Submission> submissions;

    @OneToOne(cascade = CascadeType.ALL)
    private Event event;

    public Conference(Long id, String title, String description, String phase) {
        this.id=id;
        this.title=title;
        this.description=description;
        this.phase=phase;
    }
}
