package iss.dt.app.web.converter;

import iss.dt.app.core.model.Conference;
import iss.dt.app.core.model.ProgramCommittee;
import iss.dt.app.core.model.User;
import iss.dt.app.core.service.ConferenceService;
import iss.dt.app.web.dto.UserDto;
import iss.dt.app.web.dto.ProgramCommitteeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProgramCommitteeConverter extends BaseConverter<ProgramCommittee, ProgramCommitteeDto> {

    @Autowired private ConferenceService conferenceService;

    @Override
    public ProgramCommittee convertDtoToModel(ProgramCommitteeDto dto) {
        UserConverter userConverter = new UserConverter();
        List<User> co_chairs = dto.getCoChairs().stream().map(userConverter::convertDtoToModel).collect(Collectors.toList());
        List<User> reviewers = new ArrayList<>();
        if (dto.getReviewers() != null) {
            reviewers = dto.getReviewers().stream().map(userConverter::convertDtoToModel).collect(Collectors.toList());
        }
        Conference conference = conferenceService.findOne(dto.getConferenceId());
        return ProgramCommittee.builder()
                .id(dto.getId())
                .chair(userConverter.convertDtoToModel(dto.getChair()))
                .co_chairs(co_chairs)
                .reviewers(reviewers)
                .conference(conference)
                .build();
    }

    @Override
    public ProgramCommitteeDto convertModelToDto(ProgramCommittee programCommittee) {
        UserConverter userConverter = new UserConverter();
        List<UserDto> co_chairs = programCommittee.getCo_chairs().stream().map(userConverter::convertModelToDto).collect(Collectors.toList());
        List<UserDto> reviewers = programCommittee.getReviewers().stream().map(userConverter::convertModelToDto).collect(Collectors.toList());
        ProgramCommitteeDto pcd = new ProgramCommitteeDto (
                userConverter.convertModelToDto(programCommittee.getChair()),
                co_chairs,reviewers,
                programCommittee.getConference().getId()

        );
        pcd.setId(programCommittee.getId());

        return pcd;
    }
}
