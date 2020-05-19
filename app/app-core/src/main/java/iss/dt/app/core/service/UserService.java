package iss.dt.app.core.service;
import iss.dt.app.core.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findOne(Long id);

    User findByEmail(String email);

    User updateUser(User user); //todo :getparams

    User saveUser(User user);

    void deleteUser(Long id);
}
