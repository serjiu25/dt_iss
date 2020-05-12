package iss.dt.app.core.service;
import iss.dt.app.core.model.Paper;
public interface PaperService {
    List<Paper> findByConference(Long id);

    Paper findOne(Long id);

    Paper updatePaper(); //todo :getparams

    Paper savePaper(Paper paper);

    void deletePaper(Long id);
}