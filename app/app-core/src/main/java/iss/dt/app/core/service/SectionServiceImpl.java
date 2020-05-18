package iss.dt.app.core.service;
import iss.dt.app.core.model.Section;
import iss.dt.app.core.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SectionServiceImpl implements SectionService{
    @Autowired
    private SectionRepository repo;
    @Override
    public List<Section> findByConference(Long id){
        return repo.findAll().stream().filter(sec->sec.getEvent().getConference().getId() == id).collect(Collectors.toList());
    }
    @Override
    public Section findOne(Long id){
        return repo.findAll().stream().filter(section->section.getId() == id).findAny().orElse(null);
    }
    @Override
    @Transactional
    public Section updateSection(Section section) {
        return repo.save(section);
    }
    @Override
    public Section saveSection(Section section){
        return repo.save(section);
    }
    @Override
    public void deleteSection(Long id){
        repo.deleteById(Math.toIntExact(id));
    }
}
