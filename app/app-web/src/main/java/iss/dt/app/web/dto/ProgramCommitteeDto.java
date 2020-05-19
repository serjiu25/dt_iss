package iss.dt.app.web.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProgramCommitteeDto extends BaseDto{
    private UserDto chair;
    private List<UserDto> co_chairs;
    private ConferenceDto conference;
}
