package iss.dt.app.core.service;
import iss.dt.app.core.model.Paper;
import iss.dt.app.core.repository.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaperServiceImpl implements PaperService{
    @Autowired
    private PaperRepository repo;

    public List<Paper> findByConference(Long id){
        return repo.findAll().stream().filter(paper->paper.getSubmission().getConference().getId() == id).collect(Collectors.toList());
    }
    @Override
    public Paper findOne(Long id){
        return repo.findAll().stream().filter(paper->paper.getId() == id).findAny().orElse(null);
    }
    @Override
    @Transactional
    public Paper updatePaper(Paper paper) {
        return repo.save(paper);
    }
    @Override
    public Paper savePaper(Paper paper){
        return repo.save(paper);
    }
    @Override
    public void deletePaper(Long id){
        repo.deleteById(Math.toIntExact(id));
    }
}
