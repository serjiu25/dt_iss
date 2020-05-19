package dt.cms.model;

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
    private int id;

    private String name;
    private String abstractURL;
    private String fullURL;
    private String keywords;
    private String topics;
    private String other_authors;

}
