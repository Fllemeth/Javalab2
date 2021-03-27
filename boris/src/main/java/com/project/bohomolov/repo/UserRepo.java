package com.project.bohomolov.repo;

import com.project.bohomolov.domain.chair.Chair;
import com.project.bohomolov.domain.user.User;

import java.util.List;
import java.util.Optional;

public interface UserRepo {
    int updateUserById(Long id, User user);
    int deleteUserById(Long id);
    Optional<User> findUserById(Long id);
    List<User> findAllUser();
    void saveUser(User user);
    void saveUser(User user, Long id);
}
