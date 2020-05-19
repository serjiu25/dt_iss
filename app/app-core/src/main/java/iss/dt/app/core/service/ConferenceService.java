package iss.dt.app.core.service;
import iss.dt.app.core.model.Conference;

import java.util.List;

public interface ConferenceService {
    List<Conference> findAll();

    List<Conference> findByTopic(String topic);

    Conference findOne(Long id);

    Conference updateConference(Conference conference); //todo :getparams

    Conference saveConference(Conference conference);

    void deleteConference(Long id);
}