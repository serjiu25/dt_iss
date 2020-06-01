package iss.dt.app.core.service;

import iss.dt.app.core.model.Bid;
import iss.dt.app.core.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BidServiceImpl implements BidService {

    @Autowired
    private BidRepository repo;

    @Override
    public List<Bid> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Bid> findBySubmission(Long id) {
        return repo.findAll().stream()
                .filter(bid -> bid.getSubmission().getId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public Bid findOne(Long id) {
        return repo.findAll().stream().filter(bid -> bid.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Bid save(Bid bid) {
        return repo.save(bid);
    }
}
