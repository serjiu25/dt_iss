package iss.dt.app.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SubmissionDto extends BaseDto{
    private UserDto author;
    private PaperDto paper;
    private Long conferenceId;
}
