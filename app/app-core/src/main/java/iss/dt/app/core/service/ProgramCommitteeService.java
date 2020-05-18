package iss.dt.app.core.service;
import iss.dt.app.core.model.ProgramCommittee;
import iss.dt.app.core.model.User;

import java.util.List;

public interface ProgramCommitteeService {
    ProgramCommittee findByConference(Long  id);

    //?? addMember(User user);
    ProgramCommittee findOne(Long id);

    ProgramCommittee updateProgramCommittee(ProgramCommittee programCommittee); //todo :getparams

    ProgramCommittee saveProgramCommittee(ProgramCommittee pc);

    void deleteProgramCommittee(Long id);
}
