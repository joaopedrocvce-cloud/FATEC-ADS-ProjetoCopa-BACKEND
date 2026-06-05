package com.fatec.timefutebol.times.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TimeRequest(
    @NotBlank(message = "O nome da seleção precisa ser registrado")
    @Size(min = 3, max = 50, message = "O nome da seleção deve ter entre 3 e 30 caracteres")
    String team,

    @NotBlank(message = "O nome do treinador precisa ser registrado")
    @Size(min = 4, max = 40, message = "O nome do treinador deve ter entre 4 e 40 caracteres")
    String trainer,

    @NotBlank(message = "O nome do capitão de time da seleção precisa ser registrado")
    @Size(min = 4, max = 40, message = "O nome do capitão de time da seleção deve ter entre 4 e 40 caracteres")
    String captain,

    @NotBlank(message = "O nome do goleiro da seleção precisa ser registrado")
    @Size(min = 4, max = 40, message = "O nome do goleiro da seleção deve ter entre 4 e 40 caracteres")
    String goalkeeper,

    @NotBlank(message = "O grupo em que a seleção está precisa ser registrado")
    @Size(min = 1, max = 2, message = "O grupo em que a seleção está deve ter entre 1 e 2 caracteres")
    String bracket
) {

}
