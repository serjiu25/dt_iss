package dt.cms.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "affiliation", nullable = false)
    private String affiliation;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "admin", nullable = false)
    private Boolean admin;

    @Column(name = "validated", nullable = false)
    private Boolean validated;

    @ManyToMany(mappedBy = "co_chairs")
    private List<ProgramCommitee> pc_co_chairs;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", affiliation='" + affiliation + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                ", validated=" + validated +
                '}';
    }
}
