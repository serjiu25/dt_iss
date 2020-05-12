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
    private int id;
    private String title;
    private String description;
    private String phase;

    @ManyToOne(cascade = CascadeType.ALL)
    private ProgramCommitee committee;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conference")
    private List<Submission> submissions;

    @OneToOne(cascade = CascadeType.ALL)
    private Event event;

}
