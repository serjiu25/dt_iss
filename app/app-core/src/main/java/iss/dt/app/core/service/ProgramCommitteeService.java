package iss.dt.app.core.service;
import iss.dt.app.core.model.ProgramCommittee;
import iss.dt.app.core.model.User;
public interface ProgramCommitteeService {
    List<ProgramCommittee> findByConference(Long  id);

    //?? addMember(User user);
    ProgramCommittee findOne(Long id);

    ProgramCommittee updateProgramCommittee(); //todo :getparams

    ProgramCommittee saveProgramCommittee(ProgramCommittee pc);

    void deleteProgramCommittee(Long id);
}
