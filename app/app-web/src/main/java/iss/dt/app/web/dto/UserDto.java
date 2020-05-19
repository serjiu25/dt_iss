package iss.dt.app.web.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserDto extends BaseDto{
    private String name;
    private String affiliation;
    private String email;
    private String password;
    private Boolean admin;
    private Boolean validated;

//    private List<ProgramCommiteeDto> pc_co_chairs;
}
