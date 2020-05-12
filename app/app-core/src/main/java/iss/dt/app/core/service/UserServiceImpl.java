package iss.dt.app.core.service;
import iss.dt.app.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo repo;
    @Override
    public List<User> findAll(){
        return repo.findAll();
    }
    @Override
    public User findOne(Long id){
        return repo.findAll().stream().filter(user->user.getId().equals(id)).findAny().orElse(null);
    }
    @Override
    @Transactional
    public User updateUser() {
        Optional<User> user = repo.findById(userID);
        user.ifPresent(u -> {
            //update
        });
        return user.orElse(null);
    }
    @Override
    public User saveUser(User user){
        return repo.save(user);
    }
    @Override
    public void deleteUser(Long id){
        repo.deleteById(id);
    }
}
