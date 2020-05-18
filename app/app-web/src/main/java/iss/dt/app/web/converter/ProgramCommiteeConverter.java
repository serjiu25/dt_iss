package iss.dt.app.web.converter;

import iss.dt.app.core.model.ProgramCommitee;
import iss.dt.app.core.model.User;
import iss.dt.app.web.dto.BaseDto;
import iss.dt.app.web.dto.CuserDto;
import iss.dt.app.web.dto.ProgramCommiteeDto;

import java.util.List;
import java.util.stream.Collectors;

public class ProgramCommiteeConverter implements Converter<ProgramCommitee, ProgramCommiteeDto> {

    @Override
    public ProgramCommitee convertDtoToModel(ProgramCommiteeDto dto) {
        CuserConverter cuserConverter=new CuserConverter();
        List<User> ul= dto.getCo_chairs().stream().map(cuserConverter::convertDtoToModel).collect(Collectors.toList());
        ProgramCommitee programCommitee = new ProgramCommitee(dto.getId(),cuserConverter.convertDtoToModel(dto.getChair()),ul);

        return programCommitee;
    }

    @Override
    public ProgramCommiteeDto convertModelToDto(ProgramCommitee programCommitee) {
        CuserConverter cuserConverter=new CuserConverter();
        List<CuserDto> ul= programCommitee.getCo_chairs().stream().map(cuserConverter::convertModelToDto).collect(Collectors.toList());
        ProgramCommiteeDto pcd=new ProgramCommiteeDto(cuserConverter.convertModelToDto(programCommitee.getChair()),ul);
        pcd.setId(programCommitee.getId());

        return pcd;
    }
}
