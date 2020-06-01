package iss.dt.app.web.converter;

import iss.dt.app.core.model.Submission;
import iss.dt.app.core.service.ConferenceService;
import iss.dt.app.web.dto.SubmissionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubmissionConverter extends BaseConverter<Submission, SubmissionDto> {
    UserConverter cuc=new UserConverter();
    PaperConverter pc=new PaperConverter();
    ConferenceConverter cc= new ConferenceConverter();

    @Autowired private ConferenceService conferenceService;

    @Override
    public Submission convertDtoToModel(SubmissionDto dto) {
        return Submission.builder()
                .id(dto.getId())
                .author(cuc.convertDtoToModel(dto.getAuthor()))
                .paper(pc.convertDtoToModel(dto.getPaper()))
                .conference(conferenceService.findOne(dto.getConferenceId()))
                .build();
    }

    @Override
    public SubmissionDto convertModelToDto(Submission submission) {
        UserConverter cuc=new UserConverter();
        PaperConverter pc=new PaperConverter();
        ConferenceConverter cc= new ConferenceConverter();
        SubmissionDto submissiondtp=new SubmissionDto(cuc.convertModelToDto(submission.getAuthor())
                                                    ,pc.convertModelToDto(submission.getPaper())
                                                    ,submission.getConference().getId());
        submissiondtp.setId(submission.getId());
        return submissiondtp;
    }
}
