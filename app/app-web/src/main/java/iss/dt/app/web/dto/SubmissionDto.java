package iss.dt.app.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SubmissionDto extends BaseDto{
    private int authorId;
    private int conferenceId;
    private int paperId;
    //private CuserDto author; ???
    //private conferenceDto conference;
    //private PaperDto paper;
}
