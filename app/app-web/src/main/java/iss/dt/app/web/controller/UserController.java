package iss.dt.app.web.controller;

import iss.dt.app.core.model.User;
import iss.dt.app.core.service.UserService;
import iss.dt.app.web.converter.UserConverter;
import iss.dt.app.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

class EmailObject {
    public String email;
}

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private UserConverter converter;

    //todo: login logout posts , updateUser fields

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UserDto login(@RequestBody UserDto dto) {
        if (dto == null || dto.getEmail() == null || dto.getPassword() == null) {
            return null;
        }
        User user = service.findByEmail(dto.getEmail());
        if (user == null) {
            return null;
        }
        if (!user.getPassword().equals(dto.getPassword())) {
            return null;
        }
        return converter.convertModelToDto(user);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public UserDto register(@RequestBody UserDto userDto) {
        if (service.findByEmail(userDto.getEmail()) != null)
            return null;

        User user = converter.convertDtoToModel(userDto);
        user.setAdmin(false);
        user.setValidated(true);

        return converter.convertModelToDto(service.saveUser(user));
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<UserDto> getUsers() {
        //log.trace("getUsers");
        List<User> users = service.findAll();
        //log.trace("getUsers: users={}", users);
        return new ArrayList<>(converter.convertModelsToDtos(users));
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public UserDto getUser(@PathVariable Long userId) {
        //log.trace("getUser");
        User user = service.findOne(userId);
        //log.trace("getUser: users={}", user);
        return converter.convertModelToDto(user);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/users/email", method = RequestMethod.POST)
    public UserDto getUserByEmail(@RequestBody EmailObject emailObject) {
        //log.trace("getUser");
        User user = service.findByEmail(emailObject.email);
        //log.trace("getUser: users={}", user);
        return converter.convertModelToDto(user);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)
    public UserDto updateUser(
            @PathVariable final Long userId,
            @RequestBody final UserDto userDto) {
        //log.trace("updateUser: userId={}, userDtoMap={}", userId, userDto);
        userDto.setId(userId);
        User user = service.updateUser(converter.convertDtoToModel(userDto));
        //log.trace("updateUser: result={}", result);

        return converter.convertModelToDto(user);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    UserDto saveUser(@RequestBody UserDto userDto) {
        User user = converter.convertDtoToModel(userDto);
        user.setAdmin(false);
        user.setValidated(true);
        return converter.convertModelToDto(
                service.saveUser(user)
        );
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
