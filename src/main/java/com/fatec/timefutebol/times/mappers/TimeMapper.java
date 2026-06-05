package com.fatec.timefutebol.times.mappers;

import com.fatec.timefutebol.times.dtos.TimeResponse;
import com.fatec.timefutebol.times.dtos.TimeRequest;
import com.fatec.timefutebol.times.entities.Time;

public class TimeMapper {
    
    public static Time toEntity(TimeRequest request){
        Time t = new Time();
        t.setTeam(request.team());
        t.setTrainer(request.trainer());
        t.setCaptain(request.captain());
        t.setGoalkeeper(request.goalkeeper());
        t.setBracket(request.bracket());

        return t;
    }
    
    public static TimeResponse toDTO(Time time){
        return new TimeResponse(
            time.getId(),
            time.getTeam(),
            time.getTrainer(),
            time.getCaptain(),
            time.getGoalkeeper(),
            time.getBracket()
        );
    }
}
