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
    private List<UserDto> co_chairs; // we forgot to make UsersDto like mpp or don't need?
    private Long conferenceId;
}
