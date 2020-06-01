package iss.dt.app.core.service;
import iss.dt.app.core.model.Conference;
import iss.dt.app.core.model.ProgramCommittee;
import iss.dt.app.core.model.Submission;
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

    @Transactional
    @Override
    public List<Conference> findForAuthor(Long id) {
        return repo.findAll().stream().filter(conf->{for(Submission s:conf.getSubmissions()){
            if(s.getAuthor().getId()==id)
                return true;
        };return false;
        }).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public List<Conference> findForPC(Long id) {
        return repo.findAll().stream().filter(conf->{
            ProgramCommittee pc=conf.getCommittee();
            if(pc.getChair().getId()==id)
                return true;
            boolean cochair= pc.getCo_chairs().stream().filter(user->user.getId()==id).findFirst().isPresent();
            if(cochair)
                return true;
            return pc.getReviewers().stream().filter(user->user.getId()==id).findFirst().isPresent();
        }).collect(Collectors.toList());
    }

    @Override
    public boolean isPC(Long id, Long userid) {
        ProgramCommittee pc= findOne(id).getCommittee();
        if(pc.getChair().getId()==id)
            return true;
        return pc.getCo_chairs().stream().filter(user->user.getId()==userid).findFirst().isPresent();
//        if(cochair)
//            return true;
//        boolean reviewer=pc.getReviewers().stream().filter(user->user.getId()==userid).findFirst().isPresent();
//        return reviewer;
    }
    @Override
    public boolean isReviewer(Long id, Long userid) {
        ProgramCommittee pc= findOne(id).getCommittee();
        return pc.getReviewers().stream().filter(user->user.getId()==userid).findFirst().isPresent();
    }

    @Override
    public boolean isAuthor(Long id, Long userid) {
        return findOne(id).getSubmissions().stream().filter(sub->sub.getAuthor().getId()==userid).findFirst().isPresent();
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