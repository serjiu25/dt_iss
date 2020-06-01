package iss.dt.app.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "bid")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Bid {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne()
    private User reviewer;

    @ManyToOne
    private Submission submission;

    private Integer rate;
}
