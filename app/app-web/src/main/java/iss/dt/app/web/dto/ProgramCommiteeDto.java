package iss.dt.app.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProgramCommiteeDto extends BaseDto{
    private int chairId;
    //private CuserDto chair; ???
}
