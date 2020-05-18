package iss.dt.app.web.converter;

import iss.dt.app.core.model.ProgramCommitee;
import iss.dt.app.core.model.User;
import iss.dt.app.web.dto.BaseDto;
import iss.dt.app.web.dto.CuserDto;
import iss.dt.app.web.dto.ProgramCommiteeDto;

import java.util.List;
import java.util.stream.Collectors;

public class CuserConverter implements Converter<User, CuserDto> {
/* User
    public User (Long id, String name,
    String affiliation, String email,
     Boolean admin, Boolean validated,
     Section section, List<ProgramCommitee> cc){

     UserDTO
     private String name;
    private String affiliation;
    private String email;
    private Boolean admin;
    private Boolean validated;
    private SectionDto section;
    private List<ProgramCommiteeDto> pc_co_chairs;
*/

    @Override
    public User convertDtoToModel(CuserDto dto) {
        /*SectionConverter sc= new SectionConverter();*/

        /*List<ProgramCommitee> pclist= dto.getPc_co_chairs()
                .stream()
                .map(pcc::convertDtoToModel)
                .collect(Collectors.toList());*/

        User user = new User(dto.getId()
                            ,dto.getName()
                            ,dto.getAffiliation()
                            ,dto.getEmail()
                            ,dto.getAdmin()
                            ,dto.getValidated());

        return user;
    }

    @Override
    public CuserDto convertModelToDto(User user) {
//        ProgramCommiteeConverter pcc=new ProgramCommiteeConverter();
/*
        SectionConverter sc= new SectionConverter();
*/

        /*List<ProgramCommiteeDto> pclist= user.getPc_co_chairs()
                .stream()
                .map(pcc::convertModelToDto)
                .collect(Collectors.toList());
*/
        CuserDto userdto = new CuserDto(user.getName()
                ,user.getAffiliation()
                ,user.getEmail()
                ,user.getAdmin()
                ,user.getValidated()
                );
        userdto.setId(user.getId());

        return userdto;
    }
}
