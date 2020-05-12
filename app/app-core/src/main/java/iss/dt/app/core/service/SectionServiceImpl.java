package iss.dt.app.core.service;
import iss.dt.app.core.model.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
public class SectionServiceImpl implements SectionService{
    @Autowired
    private SectionRepo repo;
    @Override
    public List<Section> findByConference(Long id){
        return repo.findAll().stream().filter(sec->sec.getConference().equals(id)).collect(Collectors.toList());
    }
    @Override
    public Section findOne(Long id){
        return repo.findAll().stream().filter(section->section.getId().equals(id)).findAny().orElse(null);
    }
    @Override
    @Transactional
    public Section updateSection() {
        Optional<Section> section = repo.findById(sectionID);
        section.ifPresent(s -> {
            //update
        });
        return section.orElse(null);
    }
    @Override
    public Section saveSection(Section section){
        return repo.save(section);
    }
    @Override
    public void deleteSection(Long id){
        repo.deleteById(id);
    }
}
