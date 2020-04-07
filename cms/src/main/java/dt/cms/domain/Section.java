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

    @Column(name = "chair", nullable = false)
    private User chair;

    @Column(name = "speakers", nullable = false)
    private List<User> speakers;

    @Column(name = "listener", nullable = false)
    private List<User> listener;

    @Column(name = "room", nullable = false)
    private String room;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_id")
    private Event event;

    @Override
    public String toString() {
        return "Section{" +
                "chair=" + chair +
                ", speakers=" + speakers +
                ", listener=" + listener +
                ", room='" + room + '\'' +
                '}';
    }
}