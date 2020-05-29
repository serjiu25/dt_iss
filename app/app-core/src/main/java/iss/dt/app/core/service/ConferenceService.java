package iss.dt.app.core.service;
import iss.dt.app.core.model.Conference;

import java.util.List;

public interface ConferenceService {
    List<Conference> findAll();

    List<Conference> findByTopic(String topic);
    List<Conference> findForAuthor(Long id);
    List<Conference> findForPC(Long id);
    public boolean isReviewer(Long id, Long userid);
    boolean isPC(Long id,Long userid);
    boolean isAuthor(Long id,Long userid);
    Conference findOne(Long id);

    Conference updateConference(Conference conference); //todo :getparams

    Conference saveConference(Conference conference);

    void deleteConference(Long id);


}