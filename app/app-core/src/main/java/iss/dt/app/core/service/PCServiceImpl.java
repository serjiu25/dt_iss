package iss.dt.app.core.service;
import iss.dt.app.core.model.ProgramCommittee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PCServiceImpl implements ProgramCommitteeService{
    @Autowired
    private ProgramCommitteeRepo repo;
    @Override
    public ProgramCommittee findByConference(Long id){
        return repo.findAll().stream().filter(pc->pc.getId().equals(id)).findAny().orElse(null);
    }
    @Override
    public ProgramCommittee findOne(Long id){
        return repo.findAll().stream().filter(pc->pc.getId().equals(id)).findAny().orElse(null);
    }
    @Override
    @Transactional
    public ProgramCommittee updateProgramCommittee() {
        Optional<ProgramCommittee> programCommittee = repo.findById(programCommitteeID);
        programCommittee.ifPresent(u -> {
            //update
        });
        return programCommittee.orElse(null);
    }
    @Override
    public ProgramCommittee saveProgramCommittee(ProgramCommittee programCommittee){
        return repo.save(programCommittee);
    }
    @Override
    public void deleteProgramCommittee(Long id){
        repo.deleteById(id);
    }
}
