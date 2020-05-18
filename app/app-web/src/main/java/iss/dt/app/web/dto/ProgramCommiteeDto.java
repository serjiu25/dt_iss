package iss.dt.app.web.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProgramCommiteeDto extends BaseDto{
    private CuserDto chair;
    private List<CuserDto> co_chairs;
}
