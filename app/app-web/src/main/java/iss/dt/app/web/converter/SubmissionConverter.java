package iss.dt.app.web.converter;

import iss.dt.app.core.model.Submission;
import iss.dt.app.web.dto.BaseDto;
import iss.dt.app.web.dto.SubmissionDto;

public class SubmissionConverter implements Converter<Submission, SubmissionDto> {
    CuserConverter cuc=new CuserConverter();
    PaperConverter pc=new PaperConverter();
    ConferenceConverter cc= new ConferenceConverter();
    @Override
    public Submission convertDtoToModel(SubmissionDto dto) {
        Submission submission=new Submission(dto.getId()
                                            ,cuc.convertDtoToModel(dto.getAuthor())
                                            ,pc.convertDtoToModel(dto.getPaper())
                                            ,cc.convertDtoToModel(dto.getConference()));


        return submission;
    }

    @Override
    public SubmissionDto convertModelToDto(Submission submission) {
        CuserConverter cuc=new CuserConverter();
        PaperConverter pc=new PaperConverter();
        ConferenceConverter cc= new ConferenceConverter();
        SubmissionDto submissiondtp=new SubmissionDto(cuc.convertModelToDto(submission.getAuthor())
                                                    ,pc.convertModelToDto(submission.getPaper())
                                                    ,cc.convertModelToDto(submission.getConference()));
        submissiondtp.setId(submission.getId());
        return submissiondtp;
    }
}
