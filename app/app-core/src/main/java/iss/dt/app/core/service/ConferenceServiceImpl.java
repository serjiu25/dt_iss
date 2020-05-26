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
public class ConferenceServiceImpl implements ConferenceService {
    @Autowired
    private ConferenceRepository repo;

    @Override
    public List<Conference> findAll() {
        return repo.findAll();
    }

    public List<Conference> findByTopic(String topic) {
        return repo.findAll().stream().filter(conf -> conf.getDescription().contains(topic)).collect(Collectors.toList());
    }

    @Override
    public List<Conference> findForAuthor(Long id) {
        return repo.findAll().stream().filter(conf -> {
            for (Submission s : conf.getSubmissions()) {
                if (s.getAuthor().getId().equals(id))
                    return true;
            }
            return false;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Conference> findForPC(Long id) {
        return repo.findAll().stream().filter(conf -> {
            ProgramCommittee pc = conf.getCommittee();
            if (pc.getChair().getId().equals(id))
                return true;
            return pc.getCo_chairs().stream().anyMatch(user -> user.getId().equals(id));//todo:change when we add reviewers too
        }).collect(Collectors.toList());
    }

    @Override
    public boolean isPC(Long id, Long userid) {
        ProgramCommittee pc = findOne(id).getCommittee();
        if (pc.getChair().getId().equals(id))
            return true;
        return pc.getCo_chairs().stream().anyMatch(user -> user.getId().equals(userid)); //todo:change when we add reviewers too
    }

    @Override
    public boolean isAuthor(Long id, Long userid) {
        return findOne(id).getSubmissions().stream().anyMatch(sub -> sub.getAuthor().getId().equals(userid));
    }

    @Override
    public Conference findOne(Long id) {
        return repo.findAll().stream().filter(conference -> conference.getId().equals(id)).findAny().orElse(null);
    }

    @Override
    @Transactional
    public Conference updateConference(Conference conference) {
        return repo.save(conference);
    }

    @Override
    public Conference saveConference(Conference conference) {
        return repo.save(conference);
    }

    @Override
    public void deleteConference(Long id) {
        repo.deleteById(Math.toIntExact(id));
    }
}