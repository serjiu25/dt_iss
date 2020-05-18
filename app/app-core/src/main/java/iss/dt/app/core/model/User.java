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
    private Long id;

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
    private List<ProgramCommitee> pc_co_chairs;
    //Converter constructor

    public User (Long id, String name, String affiliation, String email, Boolean admin, Boolean validated){
        this.id=id;
        this.name=name;
        this.affiliation=affiliation;
        this.email=email;
        this.admin=admin;
        this.validated=validated;
        //this.section=section;
//        this.pc_co_chairs=cc;
    }
}
