package iss.dt.app.core.model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Discipline extends BaseEntity<Long> {
    private String name;
    private String teacher;
    private int credits;

}
