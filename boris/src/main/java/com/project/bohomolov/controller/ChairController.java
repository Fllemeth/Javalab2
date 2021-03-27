package com.project.bohomolov.controller;

import com.project.bohomolov.domain.chair.Chair;
import com.project.bohomolov.exception.ChairAlreadyExistsException;
import com.project.bohomolov.exception.ChairNotFoundException;
import com.project.bohomolov.service.ChairService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("chair")
public class ChairController {
    private ChairService chairService;

    @GetMapping
    public List<Chair> ChairList() {
        return chairService.findAllChair();
    }

    @GetMapping("{id}")
    public Chair ChairById(@PathVariable Long id) throws ChairNotFoundException {
        return chairService.findChairById(id).orElseThrow(ChairNotFoundException::new);
    }

    @PutMapping("{id}")
    public List<Chair> updateChair(@PathVariable Long id, @RequestBody Chair chair) {
        if(chairService.findChairById(id).isPresent()) {
            chairService.updateChairById(id, chair);
        }
        else {
            chairService.saveChair(chair, id);
        }
        return chairService.findAllChair();
    }

    @DeleteMapping("{id}")
    public List<Chair> deleteChair(@PathVariable Long id) {
        chairService.deleteChairById(id);
        return chairService.findAllChair();
    }

    @PostMapping
    public List<Chair> saveChair(@RequestBody Chair chair) throws ChairAlreadyExistsException {
        if(chairService.findAllChair().contains(chair)) {
            throw new ChairAlreadyExistsException();
        }
        else {
            chairService.saveChair(chair);
            return chairService.findAllChair();
        }
    }
}
