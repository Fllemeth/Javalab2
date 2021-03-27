package com.project.bohomolov.repo.fake;

import com.project.bohomolov.domain.chair.Chair;
import com.project.bohomolov.repo.ChairRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("FakeChair")
public class ChairDataAccess implements ChairRepo {

    Long counter = 3L;
    private final List<Chair> chairs = new ArrayList<>();

    public ChairDataAccess() {
        chairs.add(new Chair(1L,10, null, null, 100, null));
        chairs.add(new Chair(2L,20, null, null, 200, null));
        chairs.add(new Chair(3L,30, null, null, 300, null));
    }

    @Override
    public int updateChairById(Long id, Chair chair) {
        return findChairById(id).
                map(aidkit -> {
                    int indexOfAidKitToDelete = chairs.indexOf(aidkit);
                    if (indexOfAidKitToDelete >= 0) {
                        chairs.set(indexOfAidKitToDelete, chair);
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public int deleteChairById(Long id) {
        Optional<Chair> aidKitMaybe = findChairById(id);
        if(!aidKitMaybe.isPresent()) return 0;
        chairs.remove(aidKitMaybe.get());
        return 1;
    }

    @Override
    public Optional<Chair> findChairById(Long id) {
        return chairs.stream().
                filter(aidkit -> aidkit.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Chair> findAllChair() {
        return chairs;
    }

    @Override
    public void saveChair(Chair chair) {
        chair.setId(++counter);
        chairs.add(chair);
    }

    @Override
    public void saveChair(Chair chair, Long id) {
        chair.setId(id);
        chairs.add(chair);
    }
}
