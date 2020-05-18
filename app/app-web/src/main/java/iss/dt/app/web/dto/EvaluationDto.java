package iss.dt.app.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class EvaluationDto extends BaseDto{
    private String result;
    private String justification;


    private SubmissionDto submission;
    private CuserDto reviewer;

}
