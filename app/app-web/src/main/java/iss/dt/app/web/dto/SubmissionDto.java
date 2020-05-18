package iss.dt.app.web.dto;

import iss.dt.app.core.model.Conference;
import iss.dt.app.core.model.Paper;
import iss.dt.app.core.model.User;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SubmissionDto extends BaseDto{
    private CuserDto author;
    private PaperDto paper;
    private ConferenceDto conference;
}
