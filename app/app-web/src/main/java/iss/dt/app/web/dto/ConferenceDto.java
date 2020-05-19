package iss.dt.app.web.dto;

import iss.dt.app.core.model.ProgramCommittee;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ConferenceDto extends BaseDto{
    private String description;
    private String phase;
    private String title;
    private Long eventID;
}
