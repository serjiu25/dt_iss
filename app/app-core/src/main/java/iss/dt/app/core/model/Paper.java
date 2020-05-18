package iss.dt.app.core.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "paper")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Paper {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String abstractURL;
    private String fullURL;
    private String keywords;
    private String topics;
    private String other_authors;

}
