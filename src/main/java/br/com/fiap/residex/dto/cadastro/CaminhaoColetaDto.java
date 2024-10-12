package br.com.fiap.residex.dto.cadastro;

import jakarta.validation.constraints.NotBlank;

public record CaminhaoColetaDto(

        Long idCaminhao,

        @NotBlank
        String placa
) {
}
