package iss.dt.app.web.converter;

import iss.dt.app.core.model.ProgramCommittee;
import iss.dt.app.core.model.User;
import iss.dt.app.web.dto.UserDto;
import iss.dt.app.web.dto.ProgramCommitteeDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProgramCommitteeConverter extends BaseConverter<ProgramCommittee, ProgramCommitteeDto> {

    @Override
    public ProgramCommittee convertDtoToModel(ProgramCommitteeDto dto) {
        UserConverter userConverter = new UserConverter();
        List<User> co_chairs = dto.getCo_chairs().stream().map(userConverter::convertDtoToModel).collect(Collectors.toList());

        return new ProgramCommittee(
                dto.getId(),
                userConverter.convertDtoToModel(dto.getChair()),
                co_chairs,
                new ConferenceConverter().convertDtoToModel(dto.getConference())
        );
    }

    @Override
    public ProgramCommitteeDto convertModelToDto(ProgramCommittee programCommittee) {
        UserConverter userConverter = new UserConverter();
        List<UserDto> co_chairs = programCommittee.getCo_chairs().stream().map(userConverter::convertModelToDto).collect(Collectors.toList());
        ProgramCommitteeDto pcd = new ProgramCommitteeDto(
                userConverter.convertModelToDto(programCommittee.getChair()),
                co_chairs,
                new ConferenceConverter().convertModelToDto(programCommittee.getConference())
        );
        pcd.setId(programCommittee.getId());

        return pcd;
    }
}
