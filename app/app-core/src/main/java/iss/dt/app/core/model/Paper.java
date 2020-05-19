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

    @OneToOne(mappedBy = "paper")
    private Submission submission;

    public Paper(Long id, String name, String abstractURL, String fullURL,
                 String keywords, String topics, String other_authors) {
        this.id = id;
        this.name = name;
        this.abstractURL = abstractURL;
        this.fullURL = fullURL;
        this.keywords = keywords;
        this.topics = topics;
        this.other_authors = other_authors;
    }

}
