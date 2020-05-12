package iss.dt.app.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CuserDto extends BaseDto{
    private Boolean admin;
    private String affiliation;
    private String email;
    private String name;
    //Cuser should not have password field
    private Boolean validated;
    private int sectionId;
    //private SectionDto section;
}
