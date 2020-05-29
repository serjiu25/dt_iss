package iss.dt.app.web.converter;

import iss.dt.app.core.model.Conference;
import iss.dt.app.web.dto.ConferenceDto;
import org.springframework.stereotype.Component;

@Component
public class ConferenceConverter extends BaseConverter<Conference, ConferenceDto> {
    @Override
    public Conference convertDtoToModel(ConferenceDto dto) {
        return new Conference(
                dto.getId(),
                dto.getTitle(),
                dto.getDescription(),
                dto.getPhase()
        );
    }

    @Override
    public ConferenceDto convertModelToDto(Conference conference) {
        ConferenceDto conferenceDto = new ConferenceDto(conference.getTitle(),
                                                        conference.getDescription(),
                                                        conference.getPhase()
        );
        conferenceDto.setId(conference.getId());
        return conferenceDto;
    }
}
