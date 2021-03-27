package com.project.bohomolov.repo;

import com.project.bohomolov.domain.chair.Chair;

import java.util.List;
import java.util.Optional;

public interface ChairRepo {
    int updateChairById(Long id, Chair chair);
    int deleteChairById(Long id);
    Optional<Chair> findChairById(Long id);
    List<Chair> findAllChair();
    void saveChair(Chair chair);
    void saveChair(Chair chair, Long id);
}
