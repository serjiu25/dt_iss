package dt.cms.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Event")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "event")
    private List<Section> sections;

//    @OneToOne(mappedBy = "event")
////    private Conference conference;

    @Override
    public String toString() {
        return  "Event { id=" + id + " }";

    }
}
