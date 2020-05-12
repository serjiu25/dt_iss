package iss.dt.app.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SectionDto extends BaseDto{
    private String room;
    private int chairId;
    private int eventId;
    //private CuserDto chair; ???
    //private EventDto event;
}
