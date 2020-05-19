package iss.dt.app.web.converter;

import iss.dt.app.core.model.Section;
import iss.dt.app.web.dto.SectionDto;
import org.springframework.stereotype.Component;

@Component
public class SectionConverter extends BaseConverter<Section, SectionDto> {
    @Override
    public Section convertDtoToModel(SectionDto dto) {
        EventConverter ec = new EventConverter();
        UserConverter cc = new UserConverter();

        return new Section(
                dto.getId(),
                cc.convertDtoToModel(dto.getChair()),
                dto.getRoom()
        );
    }

    @Override
    public SectionDto convertModelToDto(Section section) {
        EventConverter ec = new EventConverter();
        UserConverter cc = new UserConverter();

        SectionDto sectiondto = new SectionDto(cc.convertModelToDto(section.getChair()), section.getRoom(),section.getEvent().getId());
        sectiondto.setId(section.getId());
        return sectiondto;
    }
}
