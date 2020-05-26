package iss.dt.app.core.service;
import iss.dt.app.core.model.ProgramCommittee;
import iss.dt.app.core.repository.ProgramCommitteeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProgramCommitteeServiceImpl implements ProgramCommitteeService{
    @Autowired
    private ProgramCommitteeRepository repo;
    @Override
    public ProgramCommittee findByConference(Long id){
        return repo.findAll().stream().filter(pc->pc.getConference().getId() == id).findFirst().orElse(null);
    }
    @Override
    public ProgramCommittee findOne(Long id){
        return repo.findAll().stream().filter(pc-> pc.getId().equals(id)).findAny().orElse(null);
    }
    @Override
    @Transactional
    public ProgramCommittee updateProgramCommittee(ProgramCommittee programCommittee) {
        return repo.save(programCommittee);
    }
    @Override
    public ProgramCommittee saveProgramCommittee(ProgramCommittee programCommittee){
        return repo.save(programCommittee);
    }
    @Override
    public void deleteProgramCommittee(Long id){
        repo.deleteById(Math.toIntExact(id));
    }
}
