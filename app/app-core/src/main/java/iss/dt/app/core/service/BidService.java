package iss.dt.app.core.service;

import iss.dt.app.core.model.Bid;

import java.util.List;

public interface BidService {
    List<Bid> findAll();

    List<Bid> findBySubmission(Long id);

    Bid findOne(Long id);

    Bid save(Bid bid);
}
