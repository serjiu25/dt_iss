package iss.dt.app.web.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class EventDto extends BaseDto{
//    private List<SectionDto> sections;
    private ConferenceDto conference;
}
