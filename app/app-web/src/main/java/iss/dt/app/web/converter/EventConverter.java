package iss.dt.app.web.converter;

import iss.dt.app.core.model.Event;
import iss.dt.app.core.model.Section;
import iss.dt.app.web.dto.BaseDto;
import iss.dt.app.web.dto.EventDto;
import iss.dt.app.web.dto.SectionDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventConverter extends BaseConverter<Event, EventDto> {
    /*
    private List<SectionDto> sections;
    private ConferenceDto conference;
     */
    @Override
    public Event convertDtoToModel(EventDto dto) {
        /*SectionConverter sc = new SectionConverter();*/
        ConferenceConverter cc = new ConferenceConverter();

        /*List<Section> slist= dto.get
                .stream()
                .map(sc::convertDtoToModel)
                .collect(Collectors.toList());*/

        Event event = new Event(dto.getId()
                                ,cc.convertDtoToModel(dto.getConference()));

        return event;
    }

    @Override
    public EventDto convertModelToDto(Event event) {
        /*SectionConverter sc = new SectionConverter();*/
        ConferenceConverter cc = new ConferenceConverter();

/*
        List<SectionDto> slist= event.getSections()
                .stream()
                .map(sc::convertModelToDto)
                .collect(Collectors.toList());
*/

        EventDto eventDto = new EventDto(cc.convertModelToDto(event.getConference()));

        eventDto.setId(event.getId());

        return eventDto;
    }
}
