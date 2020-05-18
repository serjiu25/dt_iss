package iss.dt.app.core.service;
import iss.dt.app.core.model.Event;
public interface EventService {
    Event findByConference(Long id);

    Event findOne(Long id);

    Event updateEvent(Event event); //todo :getparams

    Event saveEvent(Event event);

    void deleteEvent(Long id);
}
