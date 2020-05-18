package iss.dt.app.web.converter;

import iss.dt.app.core.model.Section;
import iss.dt.app.web.dto.BaseDto;
import iss.dt.app.web.dto.SectionDto;

public class SectionConverter implements Converter<Section, SectionDto> {
    @Override
    public Section convertDtoToModel(SectionDto dto) {
        EventConverter ec=new EventConverter();
        CuserConverter cc=new CuserConverter();

        Section section=new Section(dto.getId(),cc.convertDtoToModel(dto.getChair()),dto.getRoom(),ec.convertDtoToModel(dto.getEvent()));


        return section;
    }

    @Override
    public SectionDto convertModelToDto(Section section) {
        EventConverter ec=new EventConverter();
        CuserConverter cc=new CuserConverter();

        SectionDto sectiondto=new SectionDto(cc.convertModelToDto(section.getChair()),section.getRoom(),ec.convertModelToDto(section.getEvent()));
        sectiondto.setId(section.getId());
        return sectiondto;
    }
}
