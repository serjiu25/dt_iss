package iss.dt.app.core.service;
import iss.dt.app.core.model.Section;

import java.util.List;

public interface SectionService {
    List<Section> findByConference(Long id);

    Section findOne(Long id);

    Section updateSection(Section section);//todo :getparams

    Section saveSection(Section section);

    void deleteSection(Long id);
}