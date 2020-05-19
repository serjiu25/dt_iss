package iss.dt.app.web.converter;

import iss.dt.app.core.model.User;
import iss.dt.app.web.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends BaseConverter<User, UserDto> {

    @Override
    public User convertDtoToModel(UserDto dto) {
        /*SectionConverter sc= new SectionConverter();*/

        /*List<ProgramCommitee> pclist= dto.getPc_co_chairs()
                .stream()
                .map(pcc::convertDtoToModel)
                .collect(Collectors.toList());*/

        return new User(dto.getId()
                , dto.getName()
                , dto.getAffiliation()
                , dto.getEmail()
                , dto.getPassword()
                , dto.getAdmin()
                , dto.getValidated());
    }

    @Override
    public UserDto convertModelToDto(User user) {
//        ProgramCommiteeConverter pcc=new ProgramCommiteeConverter();
/*
        SectionConverter sc= new SectionConverter();
*/

        /*List<ProgramCommiteeDto> pclist= user.getPc_co_chairs()
                .stream()
                .map(pcc::convertModelToDto)
                .collect(Collectors.toList());
*/
        UserDto userdto = new UserDto(user.getName()
                , user.getAffiliation()
                , user.getEmail()
                , user.getPassword()
                , user.getAdmin()
                , user.getValidated()
        );
        userdto.setId(user.getId());

        return userdto;
    }
}
