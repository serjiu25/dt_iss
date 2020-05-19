package iss.dt.app.core.service;
import iss.dt.app.core.model.Conference;
import iss.dt.app.core.repository.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConferenceServiceImpl implements ConferenceService{
    @Autowired
    private ConferenceRepository repo;
    @Override
    public List<Conference> findAll(){
        return repo.findAll();
    }
    public List<Conference> findByTopic(String topic){
        return repo.findAll().stream().filter(conf->conf.getDescription().contains(topic)).collect(Collectors.toList());
    }
    @Override
    public Conference findOne(Long id){
        return repo.findAll().stream().filter(conference->conference.getId() == id).findAny().orElse(null);
    }
    @Override
    @Transactional
    public Conference updateConference(Conference conference) {
        return repo.save(conference);
    }
    @Override
    public Conference saveConference(Conference conference){
        return repo.save(conference);
    }
    @Override
    public void deleteConference(Long id){
        repo.deleteById(Math.toIntExact(id));
    }
}