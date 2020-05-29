package iss.dt.app.core.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table (name = "section")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Section {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User chair;

    private String room;

    // TODO: what is this?
    /*
    @OneToMany
    @Column(name = "speakers", nullable = false)
    private List<User> speakers;

    @OneToMany
    @Column(name = "listener", nullable = false)
    private List<User> listener;*/

    @ManyToOne
    private Event event;

    public Section (Long id, User chair, String room) {
        this.id = id;
        this.chair = chair;
        this.room = room;
    }
}