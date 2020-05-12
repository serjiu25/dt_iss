package iss.dt.app.core.service;
import iss.dt.app.core.model.User;
public interface UserService {
    List<User> findAll();

    User findOne(Long id);

    User updateUser(); //todo :getparams

    User saveUser(User user);

    void deleteUser(Long id);
}
