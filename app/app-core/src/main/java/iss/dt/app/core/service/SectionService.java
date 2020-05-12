package iss.dt.app.core.service;
import iss.dt.app.core.model.Section;
public interface SectionService {
    List<Section> findByConference(Long id);

    Section findOne(Long id);

    Section updateSection();//todo :getparams

    Section saveSection(Section section);

    void deleteSection(Long id);
}