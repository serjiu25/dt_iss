package dt.cms.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "event")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Event {
    @Id
    @GeneratedValue
    private int id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private List<Section> sections;

    @OneToOne(mappedBy = "event")
    private Conference conference;

}
