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
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    private User chair;
/*
    @ManyToMany(mappedBy = "Program Comitee", fetch = FetchType.EAGER)
    private List<User> co_chairs;
    @OneToMany(mappedBy = "Program Comitee", fetch = FetchType.EAGER)
    private List<User> reviewers;
 */

    // TODO: maybe use another table?
    @ManyToMany
    private List<User> co_chairs;

    @OneToOne(mappedBy = "committee")
    private Conference conference;

}
