package iss.dt.app.core.service;
import iss.dt.app.core.model.Event;
import iss.dt.app.core.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService{
    @Autowired
    private EventRepository repo;
    public Event findByConference(Long id){
        return repo.findAll().stream().filter(pc->pc.getConference().getId() == id).findAny().orElse(null);
    }
    @Override
    public Event findOne(Long id){
        return repo.findAll().stream().filter(event->event.getId() == id).findAny().orElse(null);
    }
    @Override
    @Transactional
    public Event updateEvent(Event event) {
        return repo.save(event);
    }
    @Override
    public Event saveEvent(Event event){
        return repo.save(event);
    }
    @Override
    public void deleteEvent(Long id){
        repo.deleteById(Math.toIntExact(id));
    }
}
