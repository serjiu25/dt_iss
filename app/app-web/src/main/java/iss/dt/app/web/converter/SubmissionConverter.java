package iss.dt.app.web.converter;

import iss.dt.app.core.model.Submission;
import iss.dt.app.web.dto.SubmissionDto;
import org.springframework.stereotype.Component;

@Component
public class SubmissionConverter extends BaseConverter<Submission, SubmissionDto> {
    UserConverter cuc=new UserConverter();
    PaperConverter pc=new PaperConverter();
    ConferenceConverter cc= new ConferenceConverter();

    @Override
    public Submission convertDtoToModel(SubmissionDto dto) {
        return new Submission(
                dto.getId(),
                cuc.convertDtoToModel(dto.getAuthor()),
                pc.convertDtoToModel(dto.getPaper()),
                cc.convertDtoToModel(dto.getConference())
        );
    }

    @Override
    public SubmissionDto convertModelToDto(Submission submission) {
        UserConverter cuc=new UserConverter();
        PaperConverter pc=new PaperConverter();
        ConferenceConverter cc= new ConferenceConverter();
        SubmissionDto submissiondtp=new SubmissionDto(cuc.convertModelToDto(submission.getAuthor())
                                                    ,pc.convertModelToDto(submission.getPaper())
                                                    ,cc.convertModelToDto(submission.getConference()));
        submissiondtp.setId(submission.getId());
        return submissiondtp;
    }
}
