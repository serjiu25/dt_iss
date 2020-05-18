package iss.dt.app.web.dto;

import iss.dt.app.core.model.Event;
import iss.dt.app.core.model.User;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SectionDto extends BaseDto{
    private CuserDto chair;
    private String room;
    private EventDto event;
}
