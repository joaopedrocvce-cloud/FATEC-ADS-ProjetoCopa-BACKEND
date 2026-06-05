package com.fatec.timefutebol.times.dtos;

public record TimeResponse(

    Long id,
    String team,
    String trainer,
    String captain,
    String goalkeeper,
    String bracket

) {

}
