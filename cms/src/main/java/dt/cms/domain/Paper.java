package dt.cms.domain;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "Paper")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Paper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "abstractURL", nullable = false)
    private String abstractURL;

    @Column(name = "fullURL", nullable = false)
    private String fullURL;

    @Column(name = "keywords", nullable = false)
    private String keywords;

    @Column(name = "topics", nullable = false)
    private String topics;

    @Column(name = "otherAuthors", nullable = false)
    private String other_authors;

    @Override
    public String toString() {
        return "Paper{" +
                "name='" + name + '\'' +
                ", abstractURL='" + abstractURL + '\'' +
                ", fullURL='" + fullURL + '\'' +
                ", keywords=" + keywords +
                ", topics=" + topics +
                ", other_authors=" + other_authors +
                '}';
    }
}
