package com.project.bohomolov.controller;

import com.project.bohomolov.domain.user.User;
import com.project.bohomolov.exception.UserAlreadyExistsException;
import com.project.bohomolov.exception.UserNotFoundException;
import com.project.bohomolov.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("user")
public class UserController {

    private UserService userService;

    @GetMapping
    public List<User> UserList() {
        return userService.findAllUser();
    }

    @GetMapping("{id}")
    public User UserById(@PathVariable Long id) throws UserNotFoundException {
        return userService.findUserById(id).orElseThrow(UserNotFoundException::new);
    }

    @PutMapping("{id}")
    public List<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        if(userService.findUserById(id).isPresent()) {
            userService.updateUserById(id, user);
        }
        else {
            userService.saveUser(user, id);
        }
        return userService.findAllUser();
    }

    @DeleteMapping("{id}")
    public List<User> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return userService.findAllUser();
    }

    @PostMapping
    public List<User> saveUser(@RequestBody User user) throws UserAlreadyExistsException {
        if(userService.findAllUser().contains(user)) {
            throw new UserAlreadyExistsException();
        }
        else {
            userService.saveUser(user);
            return userService.findAllUser();
        }
    }
}
