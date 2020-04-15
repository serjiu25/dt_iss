package dt.cms.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import javax.persistence.*;

@Entity
@Table (name = "Section")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "chair_id")
    private User chair;

//    @OneToMany
//    @Column(name = "speakers", nullable = false)
//    private List<User> speakers;
//
//    @OneToMany
//    @Column(name = "listener", nullable = false)
//    private List<User> listener;

    @Column(name = "room", nullable = false)
    private String room;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Override
    public String toString() {
        return "Section{" +
                "chair=" + chair +
//                ", speakers=" + speakers +
//                ", listener=" + listener +
                ", room='" + room + '\'' +
                '}';
    }
}