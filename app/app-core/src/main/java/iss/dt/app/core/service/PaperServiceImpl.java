package iss.dt.app.core.service;
import iss.dt.app.core.model.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
public class PaperServiceImpl implements PaperService{
    @Autowired
    private PaperRepo repo;
    public List<Paper> findByConference(Long id){
        return repo.findAll().stream().filter(paper->paper.getConference().equals(id)).collect(Collectors.toList());
    }
    @Override
    public Paper findOne(Long id){
        return repo.findAll().stream().filter(paper->paper.getId().equals(id)).findAny().orElse(null);
    }
    @Override
    @Transactional
    public Paper updatePaper() {
        Optional<Paper> paper = repo.findById(paperID);
        paper.ifPresent(u -> {
            //update
        });
        return paper.orElse(null);
    }
    @Override
    public Paper savePaper(Paper paper){
        return repo.save(paper);
    }
    @Override
    public void deletePaper(Long id){
        repo.deleteById(id);
    }
}
