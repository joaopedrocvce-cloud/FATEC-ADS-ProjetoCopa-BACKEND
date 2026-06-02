package com.fatec.timefutebol.times.services;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import com.fatec.timefutebol.times.repositories.TimeRepository;
import jakarta.persistence.EntityNotFoundException;

import com.fatec.timefutebol.times.dtos.TimeRequest;
import com.fatec.timefutebol.times.dtos.TimeResponse;
import com.fatec.timefutebol.times.entities.Time;
import com.fatec.timefutebol.times.mappers.TimeMapper;

@Service
public class TimeService {

    @Autowired
    private TimeRepository repoT;

    public List<TimeResponse> findAll() {
        return repoT.findAll().stream().map(TimeMapper::toDTO).collect(Collectors.toList());
    }

    public TimeResponse findById(Long id) {
        return repoT.findById(id).map(TimeMapper::toDTO).orElseThrow(() -> new EntityNotFoundException("Seleção não encontrada"));
    }

    public void deleteById(Long id) {
        if (repoT.existsById(id)) {
            repoT.deleteById(id);
        } else {
            throw new EntityNotFoundException("Seleção não encontrada");
        }
    }

    public TimeResponse save(TimeRequest time) {
        Time t = repoT.save(TimeMapper.toEntity(time));
        return TimeMapper.toDTO(t);
    }

    public void update(Long id, TimeRequest time) {
        Time t = repoT.findById(id).orElseThrow(() -> new EntityNotFoundException("Seleção não encontrada"));

        t.setTeam(time.team());
        t.setTrainer(time.trainer());
        t.setCaptain(time.captain());
        t.setGoalkeeper(time.goalkeeper());
        t.setBracket(time.bracket());

        repoT.save(t);
    }
}