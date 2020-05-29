package iss.dt.app.core.model;

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
    private Long id;

    @OneToMany(mappedBy = "event")
    private List<Section> sections;

    @OneToOne(mappedBy = "event")
    private Conference conference;

    public Event(Long id) {
        this.id=id;
    }
}
