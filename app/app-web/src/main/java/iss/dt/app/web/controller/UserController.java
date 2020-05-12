package iss.dt.app.web.controller;

import iss.dt.app.core.model.User;
import iss.dt.app.core.service.UserService;
import iss.dt.app.web.converter.UserConverter;
import iss.dt.app.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    private UserConverter converter;
    //todo: login logout posts , updateUser fields
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
    public UserDto getUser(@PathVariable final Long userId) {
        //log.trace("getUser");
        User user = service.findOne(userId);
        //log.trace("getUser: users={}", user);
        return new converter.convertModelToDto(user);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)
    public UserDto updateUser(
            @PathVariable final Long userId,
            @RequestBody final UserDto userDto) {
        //log.trace("updateUser: userId={}, userDtoMap={}", userId, userDto);
        User user = service.updateUser(userId,
                userDto.getSerialNumber(),
                userDto.getName(), userDto.getGroupNumber());
        UserDto result = converter.convertModelToDto(user);
        //log.trace("updateUser: result={}", result);

        return result;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    UserDto saveUser(@RequestBody UserDto userDto) {
        return converter.convertModelToDto(
                service.saveUser(
                        converter.convertDtoToModel(userDto)
                )
        );
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
