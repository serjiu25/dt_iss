package iss.dt.app.web.dto;

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
    private int pcId;
    private int eventId;
    //private ProgramCommiteeDto pc;
    //private EventDto event;
}
