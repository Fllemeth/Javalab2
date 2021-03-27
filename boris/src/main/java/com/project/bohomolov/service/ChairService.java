package com.project.bohomolov.service;

import com.project.bohomolov.domain.chair.Chair;
import com.project.bohomolov.repo.ChairRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ChairService {
    private final ChairRepo chairRepo;

    public List<Chair> findAllChair() {
        return chairRepo.findAllChair();
    }

    public Optional<Chair> findChairById(Long id) {
        return chairRepo.findChairById(id);
    }

    public int deleteChairById(Long id) {
        return chairRepo.deleteChairById(id);
    }

    public int updateChairById(Long id, Chair chair) {
        return chairRepo.updateChairById(id, chair);
    }

    public void saveChair(Chair chair) {
        chairRepo.saveChair(chair);
    }

    public void saveChair(Chair chair, Long id) {
        chairRepo.saveChair(chair, id);
    }
}
