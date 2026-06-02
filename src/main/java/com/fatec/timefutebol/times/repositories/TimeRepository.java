package com.fatec.timefutebol.times.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fatec.timefutebol.times.entities.Time;

public interface TimeRepository extends JpaRepository<Time, Long> {

}