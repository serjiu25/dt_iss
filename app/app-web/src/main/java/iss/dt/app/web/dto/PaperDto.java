package iss.dt.app.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PaperDto extends BaseDto{
    private String name;
    private String abstractURL;
    private String fullURL;
    private String keywords;
    private String topics;
    private String other_authors;
    private SubmissionDto submission;
}
