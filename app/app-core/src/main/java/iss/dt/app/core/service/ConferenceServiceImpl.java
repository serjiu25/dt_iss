package iss.dt.app.core.service;
import iss.dt.app.core.model.Conference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
public class ConferenceServiceImpl implements ConferenceService{
    @Autowired
    private ConferenceRepo repo;
    @Override
    public List<Conference> findAll(){
        return repo.findAll();
    }
    public List<Conference> findByTopic(String topic){
        return repo.findAll().stream().filter(conf->conf.getDescription().contains(topic)).collect(Collectors.toList());
    }
    @Override
    public Conference findOne(Long id){
        return repo.findAll().stream().filter(conference->conference.getId().equals(id)).findAny().orElse(null);
    }
    @Override
    @Transactional
    public Conference updateConference() {
        Optional<Conference> conference = repo.findById(conferenceID);
        conference.ifPresent(u -> {
            //update
        });
        return conference.orElse(null);
    }
    @Override
    public Conference saveConference(Conference conference){
        return repo.save(conference);
    }
    @Override
    public void deleteConference(Long id){
        repo.deleteById(id);
    }
}