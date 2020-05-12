package iss.dt.app.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class EvaluationDto extends BaseDto{
    private String justification;
    private String result;
    private int userId;
    private int submissionId;
    //private CuserDto user;
    //private SubmissionDto submission;

}
