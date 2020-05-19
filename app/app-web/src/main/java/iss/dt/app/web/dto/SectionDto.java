package iss.dt.app.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SectionDto extends BaseDto{
    private UserDto chair;
    private String room;
    private EventDto event;
}
