package com.project.bohomolov.repo.fake;

import com.project.bohomolov.domain.chair.Chair;
import com.project.bohomolov.domain.user.User;
import com.project.bohomolov.repo.UserRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("FakeUser")
public class UserDataAccess implements UserRepo {

    Long counter = 3L;
    private final List<User> users = new ArrayList<>();

    public UserDataAccess() {
        users.add(new User(1L,"Ivan", "Ivanovich", null, null, null, null, null));
        users.add(new User(2L,"Pavlo", "Pavlovich", null, null, null, null, null));
        users.add(new User(3L, "Stepan", "Stepanovich", null, null, null, null, null));
    }

    @Override
    public int updateUserById(Long id, User user) {
        return findUserById(id).
                map(aidkit -> {
                    int indexOfAidKitToDelete = users.indexOf(aidkit);
                    if (indexOfAidKitToDelete >= 0) {
                        users.set(indexOfAidKitToDelete, user);
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public int deleteUserById(Long id) {
        Optional<User> userMaybe = findUserById(id);
        if(!userMaybe.isPresent()) return 0;
        users.remove(userMaybe.get());
        return 1;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return users.stream().
                filter(user -> user.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<User> findAllUser() {
        return users;
    }

    @Override
    public void saveUser(User user) {
        user.setId(++counter);
        users.add(user);
    }

    @Override
    public void saveUser(User user, Long id) {
        user.setId(id);
        users.add(user);
    }
}
