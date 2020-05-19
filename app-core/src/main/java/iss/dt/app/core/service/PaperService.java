package iss.dt.app.core.service;
import iss.dt.app.core.model.Paper;

import java.util.List;

public interface PaperService {
    List<Paper> findByConference(Long id);

    Paper findOne(Long id);

    Paper updatePaper(Paper paper); //todo :getparams

    Paper savePaper(Paper paper);

    void deletePaper(Long id);
}