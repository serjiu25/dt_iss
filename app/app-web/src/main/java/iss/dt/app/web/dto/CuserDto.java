package iss.dt.app.web.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CuserDto extends BaseDto{
    private String name;
    private String affiliation;
    private String email;
    private Boolean admin;
    private Boolean validated;

//    private List<ProgramCommiteeDto> pc_co_chairs;
}
