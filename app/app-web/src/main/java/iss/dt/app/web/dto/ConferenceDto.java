package iss.dt.app.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ConferenceDto extends BaseDto{
    private String title;
    private String description;
    private String phase;
}
