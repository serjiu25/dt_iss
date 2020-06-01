package iss.dt.app.core.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;

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

//    @ManyToMany(fetch = FetchType.EAGER)
//    private List<User> speakers;
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    private List<User> listener;

    @ManyToOne
    private Event event;

    public Section (Long id, User chair, String room) {
        this.id = id;
        this.chair = chair;
        this.room = room;
    }
}