package iss.dt.app.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PaperDto extends BaseDto{
    private String abstractUrl;
    private String fullUrl;
    private String keywords;
    private String name;
    private String otherAuthors;
    private String topics;
}
