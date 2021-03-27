package com.project.bohomolov.service;

import com.project.bohomolov.domain.user.User;
import com.project.bohomolov.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepo userRepo;

    public List<User> findAllUser() {
        return userRepo.findAllUser();
    }

    public Optional<User> findUserById(Long id) {
        return userRepo.findUserById(id);
    }

    public int deleteUserById(Long id) {
        return userRepo.deleteUserById(id);
    }

    public int updateUserById(Long id, User user) {
        return userRepo.updateUserById(id, user);
    }

    public void saveUser(User user) {
        userRepo.saveUser(user);
    }

    public void saveUser(User user, Long id) {
        userRepo.saveUser(user, id);
    }
}
