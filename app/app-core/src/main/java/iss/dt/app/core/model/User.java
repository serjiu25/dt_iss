package iss.dt.app.core.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cuser")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String affiliation;
    private String email;
    private String password;
    private Boolean admin;
    private Boolean validated;

    @ManyToOne(cascade = CascadeType.ALL)
    private Section section;

    // TODO: maybe use another table?
    @ManyToMany
    private List<ProgramCommittee> pc_co_chairs;

}
